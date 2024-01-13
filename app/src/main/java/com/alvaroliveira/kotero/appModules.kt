package com.alvaroliveira.kotero

import com.alvaroliveira.core.datastore.coreDataStoreModule
import com.alvaroliveira.core.network.coreNetworkModule
import com.alvaroliveira.features.auth.featuresAuthModule
import com.alvaroliveira.features.main.featuresMainModule
import org.koin.core.module.Module
import org.koin.dsl.module

val appModules: Module = module {
    includes(
        coreDataStoreModule,
        coreNetworkModule,
        featuresAuthModule,
        featuresMainModule
    )
}