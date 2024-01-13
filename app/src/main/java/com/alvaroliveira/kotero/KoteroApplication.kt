package com.alvaroliveira.kotero

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoteroApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoteroApplication)
            modules(appModules)
        }
    }
}