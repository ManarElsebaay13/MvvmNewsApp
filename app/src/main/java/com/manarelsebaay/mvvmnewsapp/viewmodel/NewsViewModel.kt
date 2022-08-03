package com.manarelsebaay.mvvmnewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarelsebaay.mvvmnewsapp.model.EgyptNewsResponse
import com.manarelsebaay.mvvmnewsapp.repository.NewsRepository
import com.manarelsebaay.mvvmnewsapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel (
    val newsRepository : NewsRepository
        ):ViewModel() {
    init {
        getEgyptNews("eg")
    }
    val  EgyptNews :MutableLiveData<Resource<EgyptNewsResponse>> = MutableLiveData()

     fun  getEgyptNews (country:String)  =  viewModelScope.launch {
         // loading
//         EgyptNews.postValue(Resource.Loading())
         // get response
         val response= newsRepository.getegyptNews(country)
         //handling Response
         EgyptNews.postValue(handlingNewsResponse(response))
    }

    private fun  handlingNewsResponse(response: Response<EgyptNewsResponse>): Resource<EgyptNewsResponse>{
        if (response.isSuccessful)
        {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())

    }


}

