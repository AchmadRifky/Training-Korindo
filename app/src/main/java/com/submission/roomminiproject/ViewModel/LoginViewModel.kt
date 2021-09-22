package com.submission.roomminiproject.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.submission.roomminiproject.Repository.RegisterRepository

class LoginViewModel(application: Application): ViewModel() {
    var mRepository: RegisterRepository ?= null

    init{
        mRepository = RegisterRepository(application)
    }

    fun getUsername(username: String, password: String) =
        mRepository?.validateRegister(username, password)

}