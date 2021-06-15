package com.nurdin.submission1jetpackpro.data.remote

import com.nurdin.submission1jetpackpro.data.response.*
import com.nurdin.submission1jetpackpro.data.retrofit.BaseApi
import com.nurdin.submission1jetpackpro.utils.DataDummy
import com.nurdin.submission1jetpackpro.utils.IdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            RemoteDataSource().apply { instance = this }
        }
    }

    fun getListMovie(callback: LoadMovieCallback) {
        IdlingResource.increment()
        BaseApi.getRetrofitService().getMovie().enqueue(object : Callback<MvResponse> {
            override fun onResponse(
                call: Call<MvResponse>,
                response: Response<MvResponse>) {
                    callback.onAllMoviesReceived(response.body()?.result)
                    IdlingResource.decrement()
                }

            override fun onFailure(call: Call<MvResponse>, t: Throwable) {
                val dummyMovies = DataDummy.generateDummyMovies()
                val resultMv = arrayListOf<MovieShow>()
                dummyMovies.forEach{ dummy ->
                    val entity = MovieShow(dummy.id, dummy.title, dummy.description, dummy.realeased, dummy.imgPoster)
                    resultMv.add(entity)
                }
                callback.onAllMoviesReceived(resultMv.toList())
                IdlingResource.decrement()
            }
        })
        }

    fun getListTvShow(callback: LoadTvShowCallback) {
        IdlingResource.increment()
        BaseApi.getRetrofitService().getTvShow().enqueue(object : Callback<TvResponse> {
            override fun onResponse(
                call: Call<TvResponse>,
                response: Response<TvResponse>) {
                    callback.onAllTVShowsReceived(response.body()?.result)
                    IdlingResource.decrement()
                }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                val dummyMovies = DataDummy.generateDummyTvShows()
                val resultTv = arrayListOf<TvShow>()
                dummyMovies.forEach{ dummy ->
                    val entity = TvShow(dummy.id, dummy.title, dummy.description, dummy.realeased, dummy.imgPoster)
                    resultTv.add(entity)
                }
                callback.onAllTVShowsReceived(resultTv.toList())
                IdlingResource.decrement()
                }
            })
        }

    fun getDetailMovies(callback: LoadDetailMovieCallback, id: Int) {
        IdlingResource.increment()
        BaseApi.getRetrofitService().getDetailMovie(id).enqueue(object : Callback<MvDetailResponse> {
                override fun onResponse(
                    call: Call<MvDetailResponse>,
                    response: Response<MvDetailResponse>
                ) {
                    callback.onAllDetailMoviesReceived(response.body())
                    IdlingResource.decrement()
                }

                override fun onFailure(call: Call<MvDetailResponse>, t: Throwable) {
                    val dummyMovies = DataDummy.generateDummyMovies()
                    val resultMovies = dummyMovies.find { it.id == id }
                    val genre = resultMovies?.genre?.map { it ->
                        GenreResponse(it.name)
                    }
                    val movies = MvDetailResponse(
                            resultMovies?.imgPoster,
                            resultMovies?.title,
                            resultMovies?.description,
                            genre,
                            resultMovies?.realeased,
                            resultMovies?.id)

                    callback.onAllDetailMoviesReceived(movies)
                    IdlingResource.decrement()
                }

            })
    }

    fun getDetailTVShows(callback: LoadDetailTvShowCallback, id: Int) {
        IdlingResource.increment()
        BaseApi.getRetrofitService().getDetailTvShow(id).enqueue(object : Callback<TvDetailResponse> {
                override fun onResponse(
                    call: Call<TvDetailResponse>,
                    response: Response<TvDetailResponse>
                ) {
                    callback.onAllDetailTVShowsReceived(response.body())
                    IdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                    val dummyTvies = DataDummy.generateDummyTvShows()
                    val resultTvies = dummyTvies.find { it.id == id }
                    val genre = resultTvies?.genre?.map { it ->
                        GenreResponse(it.name)
                    }
                    val movies = TvDetailResponse(
                            resultTvies?.imgPoster,
                            resultTvies?.title,
                            resultTvies?.description,
                            genre,
                            resultTvies?.realeased,
                            resultTvies?.id)
                    callback.onAllDetailTVShowsReceived(movies)
                    IdlingResource.decrement()
                }

            })
    }

    interface LoadMovieCallback {
        fun onAllMoviesReceived(moviesResponse: List<MovieShow>?)
    }

    interface LoadDetailMovieCallback {
        fun onAllDetailMoviesReceived(moviesDetail: MvDetailResponse?)
    }

    interface LoadTvShowCallback {
        fun onAllTVShowsReceived(tvResponse: List<TvShow>?)
    }

    interface LoadDetailTvShowCallback {
        fun onAllDetailTVShowsReceived(tvShowsDetail: TvDetailResponse?)
    }
}