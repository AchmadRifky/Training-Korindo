package com.submission.roomminiproject.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.submission.roomminiproject.Repository.ArticleRepository
import com.submission.roomminiproject.Model.Article

class ArticleAddUpdateViewModel(application: Application): ViewModel(){

    var articleLiveData: LiveData<List<Article>>?= null
    var mArticleRepository: ArticleRepository?= null

    init{
        mArticleRepository = ArticleRepository(application)
        articleLiveData = mArticleRepository?.getAllArticle()
    }

    fun insert(article: Article){
        mArticleRepository?.insertArticle(article)
    }

    fun update(article: Article){
        mArticleRepository?.updateArticle(article)
    }

    fun delete(article: Article){
        mArticleRepository?.deleteArticle(article)
    }
}