package com.submission.roomminiproject.Repository

import android.app.Application
import com.submission.roomminiproject.Dao.ArticleDao
import com.submission.roomminiproject.Database.ArticleRoomDatabase
import com.submission.roomminiproject.Model.Article
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