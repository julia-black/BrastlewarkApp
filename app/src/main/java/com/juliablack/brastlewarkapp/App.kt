package com.juliablack.brastlewarkapp

import android.app.Application
import com.juliablack.brastlewarkapp.di.appModule
import com.juliablack.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                appModule,
                dataModule
            )
        }
    }
}