package com.alvaroliveira.core.network

import CollectionsService
import com.alvaroliveira.core.datastore.AppDataStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val CACHE_SIZE = 10_737_418_240L // 10 GB

val coreNetworkModule: Module = module {

    single {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<Converter.Factory> {
        MoshiConverterFactory
            .create(get())
    }

    single {
        Dispatcher()
            .apply {
                //maxRequests = 3
            }
    }

    single {
        ZoteroTokenInterceptor(get<AppDataStore>().savedApiKey)
    }

    single {
        OkHttpClient
            .Builder()
            .dispatcher(get())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(get<ZoteroTokenInterceptor>())
            .addInterceptor {
                var request = it.request()
                val url = request.url.newBuilder().addQueryParameter("v", "3").build()
                request = request.newBuilder().url(url).build()
                it.proceed(request)
            }
            .cache(
                Cache(
                    directory = androidContext().cacheDir,
                    maxSize = CACHE_SIZE
                )
            )
            .build()

    }

    single {
        Retrofit
            .Builder()
            .client(get())
            .addConverterFactory(get())
            .baseUrl("https://api.zotero.org")
            .build()
    }

    single <CollectionsService>{
        get<Retrofit>().create(CollectionsService::class.java)
    }

}