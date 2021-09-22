package com.submission.roomminiproject.ViewModel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.Repository.RegisterRepository
import kotlinx.coroutines.Job

class RegisterViewModel(application: Application): ViewModel() {


    var mRepository: RegisterRepository ?= null

    init{
        mRepository = RegisterRepository(application)
    }

    fun insert(user: Register){
        mRepository?.insert(user)
    }
}