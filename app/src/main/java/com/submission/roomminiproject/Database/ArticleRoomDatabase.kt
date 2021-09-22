package com.submission.roomminiproject.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.submission.roomminiproject.Constant
import com.submission.roomminiproject.Dao.ArticleDao
import com.submission.roomminiproject.Dao.RegisterDao
import com.submission.roomminiproject.Model.Article
import com.submission.roomminiproject.Model.Register

@Database(entities = [
    Article::class,
    Register::class], version = 2, exportSchema = false)

abstract class ArticleRoomDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun registerDao(): RegisterDao

    companion object{
        @Volatile
        private var INSTANCE: ArticleRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): ArticleRoomDatabase{
            if(INSTANCE == null){
                synchronized(ArticleRoomDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ArticleRoomDatabase::class.java, Constant.table.DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE as ArticleRoomDatabase
        }
    }

}