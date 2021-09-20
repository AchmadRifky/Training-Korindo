package com.submission.roomminiproject

import android.app.Application
import com.submission.roomminiproject.modul.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class myApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@myApp)
            modules(
                listOf(
                    appModule
                )
            )
        }
    }
}