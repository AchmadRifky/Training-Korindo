package com.submission.roomminiproject.modul

import com.submission.roomminiproject.AppPreferences
import com.submission.roomminiproject.ViewModel.ArticleAddUpdateViewModel
import com.submission.roomminiproject.ViewModel.LoginViewModel
import com.submission.roomminiproject.ViewModel.MainViewModel
import com.submission.roomminiproject.ViewModel.RegisterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { AppPreferences(androidContext()) }
    single { MainViewModel(androidApplication()) }
    single { ArticleAddUpdateViewModel(androidApplication()) }
    single { RegisterViewModel(androidApplication()) }
    single { LoginViewModel(get()) }
}