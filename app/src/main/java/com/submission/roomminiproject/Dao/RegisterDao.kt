package com.submission.roomminiproject.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.submission.roomminiproject.Model.Article
import com.submission.roomminiproject.Model.Register

@Dao
interface RegisterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(register: Register)

    @Query("SELECT * from register_table ORDER BY id ASC")
    fun getAlluser(): LiveData<List<Register>>


    @Query("SELECT * FROM REGISTER_TABLE WHERE username=:un AND password =:pass" )
    fun validateRegister(un : String, pass: String): LiveData<List<Register>>
}
