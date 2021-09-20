package com.submission.roomminiproject.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.submission.roomminiproject.Database.ArticleRepository
import com.submission.roomminiproject.Model.Article

class ArticleAddUpdateViewModel(application: Application): ViewModel(){

    var articleLiveData: LiveData<List<Article>>?= null
    var mRepository: ArticleRepository?= null

    init{
        mRepository = ArticleRepository(application)
        articleLiveData = mRepository?.getAllArticle()
    }

    fun insert(article: Article){
        mRepository?.insertArticle(article)
    }

    fun update(article: Article){
        mRepository?.updateArticle(article)
    }

    fun delete(article: Article){
        mRepository?.deleteArticle(article)
    }
}