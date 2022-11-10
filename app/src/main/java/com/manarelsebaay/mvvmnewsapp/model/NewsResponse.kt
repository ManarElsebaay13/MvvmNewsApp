package com.manarelsebaay.mvvmnewsapp.model

import androidx.lifecycle.MutableLiveData
import com.manarelsebaay.mvvmnewsapp.model.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)