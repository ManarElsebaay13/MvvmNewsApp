package com.manarelsebaay.mvvmnewsapp.api

import com.manarelsebaay.mvvmnewsapp.model.EgyptNewsResponse
import com.manarelsebaay.mvvmnewsapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getegyptnews(
        @Query("country")
        country:String ="eg",
       @Query("apiKey")
       apikey:String= API_KEY ):Response<EgyptNewsResponse>




}