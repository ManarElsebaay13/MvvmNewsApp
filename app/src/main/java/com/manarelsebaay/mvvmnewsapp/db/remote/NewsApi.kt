package com.manarelsebaay.mvvmnewsapp.db.remote

import com.manarelsebaay.mvvmnewsapp.model.NewsResponse
import com.manarelsebaay.mvvmnewsapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getEgyptnews (
        @Query("country")
        country:String ="eg",
        @Query("page")
        pageNumber: Int = 1,
       @Query("apiKey")
       apikey:String= API_KEY ):Response<NewsResponse>


    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

}