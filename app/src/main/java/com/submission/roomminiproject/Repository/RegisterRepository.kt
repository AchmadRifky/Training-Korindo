package com.submission.roomminiproject.Repository

import com.submission.roomminiproject.Dao.RegisterDao
import com.submission.roomminiproject.Model.Register

class RegisterRepository(private val registerDao: RegisterDao) {
    val user = registerDao.getAllUser()
    suspend fun insert(user: Register){
        return registerDao.insert(user)
    }

    suspend fun getUsername(userName: String): Register{
        return registerDao.getUsername(userName)
    }

}