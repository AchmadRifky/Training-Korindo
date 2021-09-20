package com.submission.roomminiproject.Database


import androidx.lifecycle.LiveData
import androidx.room.*
import com.submission.roomminiproject.Model.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(article: Article)

    @Update
    fun update(article: Article)

    @Delete
    fun delete(article: Article)

    @Query("SELECT * from article ORDER BY id ASC")
    fun getAllArticle(): LiveData<List<Article>>
}