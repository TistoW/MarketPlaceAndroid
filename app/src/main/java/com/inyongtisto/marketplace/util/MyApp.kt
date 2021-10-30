package com.inyongtisto.marketplace.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.inyongtisto.marketplace.core.di.appModule
import com.inyongtisto.marketplace.core.di.repositoryModule
import com.inyongtisto.marketplace.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}