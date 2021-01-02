package com.nytimesarticles.data.repository

import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.common.truth.Truth.assertThat
import com.nytimesarticles.R
import com.nytimesarticles.data.Resource
import com.nytimesarticles.data.models.ArticlesApiResponse
import io.reactivex.Maybe
import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

class ArticlesRepositoryTest : LifecycleOwner {

    @Test
    fun getMostPopularArticles() {
        var result = ArticlesRepository().getMostPopularArticles(7)


//        Mockito.`when`(ArticlesRepository().getMostPopularArticles(1)).thenAnswer {
//            return@thenAnswer MutableLiveData<Resource<ArticlesApiResponse>>
//        }

//        val observer = Mockito.mock(Observer::class.java) as Observer<MutableLiveData<Resource<ArticlesApiResponse>>>
//        ArticlesRepository().getMostPopularArticles(1).observeForever(observer)
//
//        this.mainViewModel.fetchUserRepositories(ArgumentMatchers.anyString())
//
//        Assert.assertNotNull(this.mainViewModel.repositoriesLiveData.value)
//        assertEquals(LiveDataResult.Status.SUCCESS, this.mainViewModel.repositoriesLiveData.value?.status)

        val observable = ArticlesRepository().getMostPopularArticles(7)
        observable.observe(this, Observer {
            assertThat(result.value?.data).isInstanceOf(ArticlesApiResponse::class.java)
        })
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}