package com.alvaroliveira.features.auth

import com.alvaroliveira.core.data.di.coreDataModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featuresAuthModule: Module = module {
    includes(coreDataModule)
    singleOf(::AuthViewModel)
}