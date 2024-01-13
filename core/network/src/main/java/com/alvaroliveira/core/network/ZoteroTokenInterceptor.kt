package com.alvaroliveira.core.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.Response


class ZoteroTokenInterceptor(
    private val tokenFlow: Flow<String>
) : Interceptor {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private var token: String? = null

    init {
        tokenFlow
            .onEach { newToken ->
                this.token = newToken
            }
            .launchIn(coroutineScope)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val modifiedRequest = originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(modifiedRequest)
    }
}