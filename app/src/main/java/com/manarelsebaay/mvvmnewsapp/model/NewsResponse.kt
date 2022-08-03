package com.manarelsebaay.mvvmnewsapp.model

import com.manarelsebaay.mvvmnewsapp.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)