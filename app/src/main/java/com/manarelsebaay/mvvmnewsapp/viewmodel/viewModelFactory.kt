package com.manarelsebaay.mvvmnewsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.manarelsebaay.mvvmnewsapp.repository.NewsRepository

class viewModelFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }




}
