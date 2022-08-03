package com.manarelsebaay.mvvmnewsapp.repository

import com.manarelsebaay.mvvmnewsapp.api.RetrofitInstance
import com.manarelsebaay.mvvmnewsapp.db.NewsDatabase

class NewsRepository (
    val newsRepository: NewsDatabase
        )
{
    suspend fun getegyptNews(country:String) =  RetrofitInstance.api.getEgyptnews(country)




}