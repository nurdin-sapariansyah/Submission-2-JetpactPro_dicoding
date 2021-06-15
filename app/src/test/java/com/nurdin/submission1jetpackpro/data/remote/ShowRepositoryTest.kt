package com.nurdin.submission1jetpackpro.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.nurdin.submission1jetpackpro.data.response.*
import com.nurdin.submission1jetpackpro.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import utils.LiveDataUtilTest

@RunWith(MockitoJUnitRunner::class)
class ShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val fakeShowRepository = FakeShowRepository(remote)
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTv = DataDummy.generateDummyTvShows()
    private val movieID = dummyMovie[0].id
    private val tvShowID = dummyTv[0].id
    private val dummyMovieDetail = MvDetailResponse(
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg",
            "A Star Is Born",
            "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
            listOf(GenreResponse("Drama, Percintaan, Musik")),
            "2018",
            1
            )

    private val dummyTvDetail =  TvDetailResponse(
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg",
            "The Arrow",
            "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
            listOf(GenreResponse("Kejahatan, Drama, Misteri")),
            "2012",
            11
    )

    @Test
    fun loadMovie() {
        val dummyMVes = DataDummy.generateDummyMovies()
        val resultOff = arrayListOf<MovieShow>()
        dummyMVes.forEach{ dummy ->
            val entity = MovieShow(dummy.id, dummy.title, dummy.description, dummy.imgPoster, dummy.realeased)
            resultOff.add(entity)
        }

        doAnswer {invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                    .onAllMoviesReceived(resultOff.toList())
            null
        }.`when`(remote).getListMovie(any())

        val movieEntity = LiveDataUtilTest.getValue(fakeShowRepository.loadMovie())
        verify(remote).getListMovie(any())
        assertEquals(dummyMovie.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun loadTvShow() {
        val dummyTVes = DataDummy.generateDummyTvShows()
        val resultOff = arrayListOf<TvShow>()
        dummyTVes.forEach{ dummy ->
            val entity = TvShow(dummy.id, dummy.title, dummy.description, dummy.imgPoster, dummy.realeased)
            resultOff.add(entity)
        }

        doAnswer {invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                    .onAllTVShowsReceived(resultOff.toList())
            null
        }.`when`(remote).getListTvShow(any())

        val tvEntity = LiveDataUtilTest.getValue(fakeShowRepository.loadTvShow())
        verify(remote).getListTvShow(any())
        assertEquals(dummyTv.size.toLong(), tvEntity.size.toLong())
    }

    @Test
    fun loadDetailMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                    .onAllDetailMoviesReceived(dummyMovieDetail)
            null
        }.`when`(remote).getDetailMovies(any(), eq(movieID))

        val movieDetailEntity =
                LiveDataUtilTest.getValue(fakeShowRepository.loadDetailMovie(movieID))
        verify(remote).getDetailMovies(any(), eq(movieID))
        assertEquals(dummyMovieDetail.id, movieDetailEntity.id)
    }

    @Test
    fun loadDetailTvShow() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback)
                    .onAllDetailTVShowsReceived(dummyTvDetail)
            null
        }.`when`(remote).getDetailTVShows(any(), eq(tvShowID))

        val tvDetailEntity =
                LiveDataUtilTest.getValue(fakeShowRepository.loadDetailTvShow(tvShowID))
        verify(remote).getDetailTVShows(any(), eq(tvShowID))
        assertEquals(dummyTvDetail.id, tvDetailEntity.id)
    }
}