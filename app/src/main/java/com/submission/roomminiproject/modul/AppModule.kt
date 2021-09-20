package com.submission.roomminiproject.modul

import com.submission.roomminiproject.AppPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { AppPreferences(androidContext()) }
}