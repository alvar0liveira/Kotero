package com.alvaroliveira.core.data.di

import com.alvaroliveira.core.common.UseCase
import com.alvaroliveira.core.data.datasource.local.CollectionLocalDataSource
import com.alvaroliveira.core.data.datasource.local.CollectionLocalDataSourceImpl
import com.alvaroliveira.core.data.datasource.local.ItemLocalDataSource
import com.alvaroliveira.core.data.datasource.local.ItemLocalDataSourceImpl
import com.alvaroliveira.core.data.datasource.remote.CollectionRemoteDataSource
import com.alvaroliveira.core.data.datasource.remote.CollectionRemoteDataSourceImpl
import com.alvaroliveira.core.data.datasource.remote.ItemRemoteDataSource
import com.alvaroliveira.core.data.datasource.remote.ItemRemoteDataSourceImpl
import com.alvaroliveira.core.data.repository.CollectionsRepository
import com.alvaroliveira.core.data.repository.CollectionsRepositoryImpl
import com.alvaroliveira.core.data.repository.ItemsRepository
import com.alvaroliveira.core.data.repository.ItemsRepositoryImpl
import com.alvaroliveira.core.data.usecase.GetAllCollectionsUseCase
import com.alvaroliveira.core.data.usecase.GetAllItemsByCollectionUseCase
import com.alvaroliveira.core.data.usecase.GetCollectionItemsUseCase
import com.alvaroliveira.core.data.usecase.GetItemByCollectionUseCase
import com.alvaroliveira.core.database.di.coreDatabaseModule
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule: Module = module {

    includes(coreDatabaseModule)

    single<CollectionLocalDataSource> {
        CollectionLocalDataSourceImpl(
            collectionsDao = get()
        )
    } bind CollectionLocalDataSource::class

    single<CollectionRemoteDataSource> {
        CollectionRemoteDataSourceImpl(
            api = get()
        )
    } bind CollectionRemoteDataSource::class

    single<ItemLocalDataSource> { // Change this
        ItemLocalDataSourceImpl(
            dao = get()
        )
    } bind ItemLocalDataSource::class

    single<ItemRemoteDataSource> {
        ItemRemoteDataSourceImpl(
            api = get()
        )
    } bind ItemRemoteDataSource::class

    single<CollectionsRepository> {
        CollectionsRepositoryImpl(
            remoteDataSource = get(),
            localDataSource = get()
        )
    }  bind CollectionsRepository::class

    single {
        ItemsRepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get()
        )
    } bind ItemsRepository::class

    single(named("getAllCollections")) {
        GetAllCollectionsUseCase(
            dispatcher = Dispatchers.IO,
            repo = get()
        )
    } bind UseCase::class

    single(named("getAllItems")) {
        GetCollectionItemsUseCase(
            dispatcher = Dispatchers.IO,
            repo = get()
        )
    } bind UseCase::class

    single(named("getAllItemsByCollection")) {
        GetAllItemsByCollectionUseCase(
            dispatcher = Dispatchers.IO,
            repo = get()
        )
    } bind UseCase::class

    single(named("getItemByCollection")) {
        GetItemByCollectionUseCase(
            dispatcher = Dispatchers.IO,
            repo = get()
        )
    } bind UseCase::class
}
