package com.manarelsebaay.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.manarelsebaay.mvvmnewsapp.model.Article
import retrofit2.http.DELETE


@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (article: Article): Long

    @Query("SELECT*FROM articles")
    fun getAllArticles ():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle (article: Article)



}