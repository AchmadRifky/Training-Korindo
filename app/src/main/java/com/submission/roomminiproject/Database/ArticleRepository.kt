package com.submission.roomminiproject.Database

import android.app.Application
import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.submission.roomminiproject.Model.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ArticleRepository(private var application: Application){

    var mDao: ArticleDao
    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    init{
        mDao = ArticleRoomDatabase.getDatabase(application).articleDao()
    }

    fun getAllArticle() = mDao.getAllArticle()

    fun insertArticle(article: Article) {
        executor.execute{mDao.insert(article)}
    }

    fun updateArticle(article: Article) {
        executor.execute{mDao.update(article)}
    }

    fun deleteArticle(article: Article){
        executor.execute{mDao.delete(article)}
    }

}