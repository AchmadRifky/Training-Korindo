package com.submission.roomminiproject.Repository

import android.app.Application
import com.submission.roomminiproject.Dao.RegisterDao
import com.submission.roomminiproject.Database.ArticleRoomDatabase
import com.submission.roomminiproject.Model.Register
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class RegisterRepository(private var application: Application) {

    var mDao: RegisterDao
    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        mDao = ArticleRoomDatabase.getDatabase(application).registerDao()
    }

    fun insert(user: Register){
        executor.execute { mDao.insert(user) }
    }

    fun validateRegister(username: String, password: String){
        executor.execute { mDao.validateRegister(username, password) }
    }

}