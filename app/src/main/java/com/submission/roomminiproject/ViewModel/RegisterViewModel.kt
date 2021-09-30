package com.submission.roomminiproject.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.Repository.RegisterRepository

class RegisterViewModel(application: Application): ViewModel() {


    var mRepository: RegisterRepository ?= null

    init{
        mRepository = RegisterRepository(application)
    }

    fun insert(user: Register){
        mRepository?.insert(user)
    }






}