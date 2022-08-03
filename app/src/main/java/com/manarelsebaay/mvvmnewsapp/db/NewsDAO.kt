package com.manarelsebaay.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manarelsebaay.mvvmnewsapp.model.Article
import retrofit2.http.DELETE


@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (article: Article): Long

    @Query("SELECT*FROM articles")
    fun getAllArticles ():LiveData<List<Article>>

    @DELETE
    suspend fun deleteArticle (article: Article)



}