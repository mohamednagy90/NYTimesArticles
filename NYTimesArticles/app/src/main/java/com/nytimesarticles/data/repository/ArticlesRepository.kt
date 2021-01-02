package com.nytimesarticles.data.repository

import androidx.lifecycle.MutableLiveData
import com.nytimesarticles.data.Resource
import com.nytimesarticles.data.apis.ArticlesApis
import com.nytimesarticles.data.models.ArticlesApiResponse


class ArticlesRepository {

    fun getMostPopularArticles(period: Int): MutableLiveData<Resource<ArticlesApiResponse>> {
        return Api.getMostPopularArticles(period)

    }


    companion object {
        private val Api by lazy { ArticlesApis() }
    }

}