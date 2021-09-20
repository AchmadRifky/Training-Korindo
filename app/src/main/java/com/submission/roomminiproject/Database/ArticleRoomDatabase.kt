package com.submission.roomminiproject.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.submission.roomminiproject.Constant
import com.submission.roomminiproject.Model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class ArticleRoomDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao

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