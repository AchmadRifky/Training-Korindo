package com.submission.roomminiproject.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.submission.roomminiproject.Repository.ArticleRepository
import com.submission.roomminiproject.Model.Article

class MainViewModel(application: Application): AndroidViewModel(application) {

    var articleLiveData: LiveData<List<Article>>?= null
    var mRepository: ArticleRepository?= null

    init{
        mRepository = ArticleRepository(application)
        articleLiveData = mRepository?.getAllArticle()
    }

    fun getAllArticleList(): LiveData<List<Article>>?{
        return articleLiveData
    }
}