package com.manarelsebaay.mvvmnewsapp.db.model

import androidx.lifecycle.MutableLiveData
import com.manarelsebaay.mvvmnewsapp.db.model.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)