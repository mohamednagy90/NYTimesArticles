package com.nytimesarticles.data.apis

import androidx.lifecycle.MutableLiveData
import com.nytimesarticles.data.ApiParams
import com.nytimesarticles.data.Resource
import com.nytimesarticles.data.RetrofitClient
import com.nytimesarticles.data.Urls
import com.nytimesarticles.data.models.ArticlesApiResponse
import com.nytimesarticles.util.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class ArticlesApis {

    companion object {
        private val api: RetrofitInterface by lazy {
            RetrofitClient.instance.create<RetrofitInterface>(RetrofitInterface::class.java)
        }
    }

    fun getMostPopularArticles(period: Int): MutableLiveData<Resource<ArticlesApiResponse>> {
        val data = MutableLiveData<Resource<ArticlesApiResponse>>()

        api.getMostPopularArticles(period).enqueue(object : Callback<ArticlesApiResponse> {
            override fun onResponse(
                call: Call<ArticlesApiResponse>?,
                response: Response<ArticlesApiResponse>?
            ) {
                data.value = Resource.create(response)
            }

            override fun onFailure(call: Call<ArticlesApiResponse>?, t: Throwable?) {
                val exception = Exception(t)
                data.value = Resource.error(exception)
            }
        })

        return data
    }


    /**
     * Retrofit interface
     */
    interface RetrofitInterface {

        @GET(Urls.getMostPopularArticles)
        fun getMostPopularArticles(
            @Path("period") period: Int,
            @Query(ApiParams.Query.api_key) api_key: String = Const.API_Key,

            ): Call<ArticlesApiResponse>

    }
}