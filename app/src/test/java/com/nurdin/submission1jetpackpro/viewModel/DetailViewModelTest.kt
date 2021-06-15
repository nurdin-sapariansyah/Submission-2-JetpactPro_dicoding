@file:Suppress("DEPRECATION")

package com.nurdin.submission1jetpackpro.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.nurdin.submission1jetpackpro.data.remote.ShowRepository
import com.nurdin.submission1jetpackpro.model.DataDetail
import com.nurdin.submission1jetpackpro.utils.Helper.MOVIE
import com.nurdin.submission1jetpackpro.utils.Helper.TV_SHOW
import junit.framework.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDetail(
            1,
            "A Star Is Born",
            "2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg",
            "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
            listOf("Drama, Percintaan, Musik")
    )

    private val dummyTv =  DataDetail(
            11,
            "The Arrow",
            "2012",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg",
            "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
             listOf("Kejahatan, Drama, Misteri")
    )

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var observer: Observer<DataDetail>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(showRepository)
    }

    @Test
    fun setDetailMovie() {
        val movies = MutableLiveData<DataDetail>()
        movies.value = dummyMovie

        Mockito.`when`(showRepository.loadDetailMovie(1)).thenReturn(movies)
        viewModel.setDetailFilm(1, MOVIE)
        val detailMvShow = viewModel.getDetailData().value
        verify(showRepository).loadDetailMovie(1)
        Assert.assertNotNull(detailMvShow)

        dummyMovie.apply {
            assertEquals(id, detailMvShow?.id)
            assertEquals(title, detailMvShow?.title)
            assertEquals(date, detailMvShow?.date)
            assertEquals(imageDetail, detailMvShow?.imageDetail)
            assertEquals(desc, detailMvShow?.desc)
            assertEquals(genres, detailMvShow?.genres)
        }

            viewModel.getDetailData().observeForever(observer)
            Mockito.verify(observer).onChanged(dummyMovie)
        }

        @Test
        fun setDetailTvShow() {
            val tvies = MutableLiveData<DataDetail>()
            tvies.value = dummyTv

            Mockito.`when`(showRepository.loadDetailTvShow(1)).thenReturn(tvies)
            viewModel.setDetailFilm(1, TV_SHOW)
            val detailMvShow = viewModel.getDetailData().value
            verify(showRepository).loadDetailTvShow(1)
            Assert.assertNotNull(detailMvShow)

            dummyTv.apply {
                assertEquals(id, detailMvShow?.id)
                assertEquals(title, detailMvShow?.title)
                assertEquals(date, detailMvShow?.date)
                assertEquals(imageDetail, detailMvShow?.imageDetail)
                assertEquals(desc, detailMvShow?.desc)
                assertEquals(genres, detailMvShow?.genres)
            }

            viewModel.getDetailData().observeForever(observer)
            Mockito.verify(observer).onChanged(dummyTv)
        }
}