package com.submission.roomminiproject.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.submission.roomminiproject.Dao.RegisterDao
import com.submission.roomminiproject.Model.Article
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.Repository.RegisterRepository

class LoginViewModel(application: Application): ViewModel() {
    var mRepository: RegisterRepository ?= null

    init{
        mRepository = RegisterRepository(application)
    }

    fun getUsername(username: String, password: String): LiveData<List<Register>>? {
        return mRepository?.getUsernameList(username, password)
    }


}