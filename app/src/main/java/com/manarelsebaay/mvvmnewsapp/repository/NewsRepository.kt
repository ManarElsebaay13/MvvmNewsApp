package com.manarelsebaay.mvvmnewsapp.repository

import com.manarelsebaay.mvvmnewsapp.db.remote.RetrofitInstance
import com.manarelsebaay.mvvmnewsapp.db.local.NewsDatabase
import com.manarelsebaay.mvvmnewsapp.db.model.Article

class NewsRepository (
    val newsDatabase: NewsDatabase
        )
{
    suspend fun getegyptNews(country:String) =  RetrofitInstance.api.getEgyptnews(country)

    suspend fun searchNewsResult(query: String)= RetrofitInstance.api.searchForNews(query)

    suspend fun insert(article: Article)=newsDatabase.getNewsDAO().insert(article)
    suspend fun delete(article: Article)=newsDatabase.getNewsDAO().deleteArticle(article)

    fun getAllArticles()=newsDatabase.getNewsDAO().getAllArticles()


}