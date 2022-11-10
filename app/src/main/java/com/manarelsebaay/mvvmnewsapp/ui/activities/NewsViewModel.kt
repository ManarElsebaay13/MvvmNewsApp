package com.manarelsebaay.mvvmnewsapp.ui.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.manarelsebaay.mvvmnewsapp.db.model.Article
import com.manarelsebaay.mvvmnewsapp.db.model.NewsResponse
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
    val  EgyptNews :MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var EgyptNewsPage = 1
    var EgyptNewsResponse: NewsResponse? = null

    val  searchNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1
    var searchNewsResponse: NewsResponse? = null


    fun  getEgyptNews (country:String)  =  viewModelScope.launch {

//         EgyptNews.postValue(Resource.Loading())
         val response= newsRepository.getegyptNews(country)
         EgyptNews.postValue(handlingNewsResponse(response))
    }

    fun getSearchResult( query: String)=viewModelScope.launch {
        val response=newsRepository.searchNewsResult(query)
        searchNews.postValue(handlingSearchResponse(response))

    }

    private fun  handlingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful)
        { response.body()?.let { resultResponse ->
            EgyptNewsPage++
            if (EgyptNewsResponse==null){
                EgyptNewsResponse=resultResponse
            }
           else {
               val oldArticles = EgyptNewsResponse?.articles
                val newArticles = resultResponse.articles
                oldArticles?.addAll(newArticles)

            }
            return Resource.Success(EgyptNewsResponse?:resultResponse) }
        }
        return Resource.Error(response.message())
    }


    private fun  handlingSearchResponse (response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful)
        {
            response.body()?.let { resultResponse ->
                searchNewsPage++
                if (searchNewsResponse==null){
                    searchNewsResponse=resultResponse
                }
                else {
                    val oldArticles = searchNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(resultResponse) }
        }
        return Resource.Error(response.message())
    }

    fun saveArticle (article: Article)=viewModelScope.launch { newsRepository.insert(article) }
    fun deletArticle (article: Article)=viewModelScope.launch { newsRepository.delete(article) }
    fun getArticles() = newsRepository.getAllArticles()





}

