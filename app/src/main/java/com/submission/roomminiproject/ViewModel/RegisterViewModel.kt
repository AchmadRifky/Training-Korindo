package com.submission.roomminiproject.ViewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.Repository.RegisterRepository
import kotlinx.coroutines.Job

class RegisterViewModel(application: Application) {

    var mRepository: RegisterRepository ?= null

    private var userData:String?= null

    var userLiveData = MutableLiveData<List<Register>>()

    val inputUsername = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()
    val inputPassword = MutableLiveData<String>()

    private suspend fun insert(user: Register) = mRepository?.insert(user)




}