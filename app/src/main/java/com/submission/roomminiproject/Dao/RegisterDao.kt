package com.submission.roomminiproject.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.submission.roomminiproject.Model.Register

@Dao
interface RegisterDao {
    @Insert
    suspend fun insert(register: Register)

    @Query("SELECT * FROM register_table")
    fun getAllUser(): LiveData<List<Register>>

    @Query("DELETE FROM register_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM register_table WHERE username LIKE username")
    suspend fun getUsername(username: String): Register
}
