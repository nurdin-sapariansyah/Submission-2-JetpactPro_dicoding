package com.nurdin.submission1jetpackpro.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.nurdin.submission1jetpackpro.data.remote.ShowRepository
import com.nurdin.submission1jetpackpro.data.response.MovieShow
import com.nurdin.submission1jetpackpro.data.response.TvShow
import com.nurdin.submission1jetpackpro.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ContentViewModelTest {

    private lateinit var movieViewModel: ContentViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var  observer: Observer<List<MovieShow>>

    @Mock
    private lateinit var  observerer: Observer<List<TvShow>>

    @Before
    fun setUp(){
        movieViewModel = ContentViewModel(showRepository)
    }

    @Test
    fun getListMovie() {
        val dummyData = DataDummy.generateDummyMovies()
        val resultMovie = arrayListOf<MovieShow>()
        dummyData.forEach {
            val entity =  MovieShow(
                it.id,
                it.title,
                it.description,
                it.realeased,
                it.imgPoster)
            resultMovie.add(entity)
        }
        val movies = MutableLiveData<List<MovieShow>>()
        movies.value = resultMovie

        Mockito.`when`(showRepository.loadMovie()).thenReturn(movies)
        val mvShowEntity = movieViewModel.getListMovie().value
        verify(showRepository).loadMovie()
        assertNotNull(mvShowEntity)
        assertEquals(10, mvShowEntity?.size)

        movieViewModel.getListMovie().observeForever(observer)
        verify(observer).onChanged(resultMovie)
    }

    @Test
    fun getListTvShow() {
        val dummyData = DataDummy.generateDummyTvShows()
        val resultTvShow = arrayListOf<TvShow>()
        dummyData.forEach {
            val entity =  TvShow(
                it.id,
                it.title,
                it.description,
                it.realeased,
                it.imgPoster)
            resultTvShow.add(entity)
        }
        val movies = MutableLiveData<List<TvShow>>()
        movies.value = resultTvShow

        Mockito.`when`(showRepository.loadTvShow()).thenReturn(movies)
        val tvShowEntity = movieViewModel.getListTvShow().value
        verify(showRepository).loadTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(10, tvShowEntity?.size)

        movieViewModel.getListTvShow().observeForever(observerer)
        verify(observerer).onChanged(resultTvShow)
    }
}