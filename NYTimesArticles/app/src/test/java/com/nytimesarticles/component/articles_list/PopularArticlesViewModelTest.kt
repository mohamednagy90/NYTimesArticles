package com.nytimesarticles.component.articles_list

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nytimesarticles.data.Resource
import com.nytimesarticles.data.apis.ArticlesApis
import com.nytimesarticles.data.models.ArticlesApiResponse
import com.nytimesarticles.data.repository.ArticlesRepository
import io.reactivex.Maybe
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class PopularArticlesViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    internal lateinit var apiClient: ArticlesApis

    @Mock
    private lateinit var repository: ArticlesRepository

    @Mock
    lateinit var viewModel: PopularArticlesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = PopularArticlesViewModel()
        viewModel.getMostPopularArticles(1)
        repository = ArticlesRepository()

    }

    @Test
    fun getMostPopularArticles() {

//        Mockito.`when`(apiClient.getMostPopularArticles(1)).thenAnswer {
//            return@thenAnswer Maybe.just(ArgumentMatchers.anyList<Resource<ArticlesApiResponse>>())
//        }

//        val observer = mock(Observer::class.java) as Observer<Resource<ArticlesApiResponse>>
//        viewModel.repositoriesLiveData.observeForever(observer)
//
//        viewModel.getMostPopularArticles(1)

//        assertNotNull(viewModel.repositoriesLiveData.value)
        assertEquals(Resource.Status.SUCCESS, viewModel.getMostPopularArticles(1).value?.status)


//        val userObserver: Observer<Resource<ArticlesApiResponse>> =
//            mock(Observer::class.java) as Observer<Resource<ArticlesApiResponse>>
//        viewModel.getMostPopularArticles(1).observeForever(userObserver)
//        var maennlich = MutableLiveData<Resource<ArticlesApiResponse>>().value
//        val userTest: MutableLiveData<Resource<ArticlesApiResponse>> =
//            MutableLiveData<Resource<ArticlesApiResponse>>()
//        userTest.postValue(maennlich)
//        `when`<Any>(apiClient.getMostPopularArticles(1)).thenReturn(userTest)
//        verify(userObserver).onChanged(maennlich)

    }
}