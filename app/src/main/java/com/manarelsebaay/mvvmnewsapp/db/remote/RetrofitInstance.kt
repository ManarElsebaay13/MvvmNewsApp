package com.manarelsebaay.mvvmnewsapp.db.remote

import com.manarelsebaay.mvvmnewsapp.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    companion object{

      private  val retrofit by lazy {

          //inteceptor logging
          val logging= HttpLoggingInterceptor()
           logging.setLevel(HttpLoggingInterceptor.Level.BODY)

          // OkHttpClient
          val client =OkHttpClient.Builder()
              .addInterceptor(logging)
              .build()

          //retrofit builder
          Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .client(client)
              .build()

      }

        val  api by lazy {
            retrofit.create(NewsApi::class.java) } }




}