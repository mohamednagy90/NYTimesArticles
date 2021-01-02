package com.nytimesarticles.component.articles_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nytimesarticles.data.Resource
import com.nytimesarticles.data.models.ArticlesApiResponse
import com.nytimesarticles.data.repository.ArticlesRepository

class PopularArticlesViewModel() : ViewModel() {

    var repositoriesLiveData = MutableLiveData<Resource<ArticlesApiResponse>>()

    fun getMostPopularArticles(period: Int): MutableLiveData<Resource<ArticlesApiResponse>> {
        var data = repository.getMostPopularArticles(period)
        repositoriesLiveData = data
        return data

    }


    companion object {
        private val repository by lazy { ArticlesRepository() }
    }

    class PopularArticlesViewModelFactory() :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PopularArticlesViewModel::class.java)) {
                return PopularArticlesViewModel() as T
            }
            throw IllegalArgumentException("Invalid View model class")
        }

    }
}