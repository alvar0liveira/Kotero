package com.alvaroliveira.features.main

import com.alvaroliveira.core.data.di.coreDataModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module

val featuresMainModule: Module = module {
    includes(coreDataModule)
    viewModel {
        MainViewModel(
            get(),
            get(named("getAllCollections")),
            get(named("getAllItems")),
            get(named("getAllItemsByCollection")),
            get(named("getItemByCollection"))
        )
    }
}