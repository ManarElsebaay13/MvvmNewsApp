package com.manarelsebaay.mvvmnewsapp.ui.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manarelsebaay.mvvmnewsapp.repository.NewsRepository

class viewModelFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }




}
