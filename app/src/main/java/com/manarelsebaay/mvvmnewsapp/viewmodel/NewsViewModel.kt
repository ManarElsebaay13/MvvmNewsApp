package com.manarelsebaay.mvvmnewsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.manarelsebaay.mvvmnewsapp.repository.NewsRepository

class NewsViewModel (
    val newsRepository : NewsRepository
        ):ViewModel() {

}