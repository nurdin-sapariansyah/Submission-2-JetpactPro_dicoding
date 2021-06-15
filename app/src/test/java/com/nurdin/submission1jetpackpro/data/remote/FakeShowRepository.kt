package com.nurdin.submission1jetpackpro.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nurdin.submission1jetpackpro.data.response.MovieShow
import com.nurdin.submission1jetpackpro.data.response.MvDetailResponse
import com.nurdin.submission1jetpackpro.data.response.TvDetailResponse
import com.nurdin.submission1jetpackpro.data.response.TvShow
import com.nurdin.submission1jetpackpro.model.DataDetail

class FakeShowRepository(private val remoteDataSource: RemoteDataSource) : ShowDS {
    override fun loadMovie(): LiveData<List<MovieShow>> {
        val getMovie = MutableLiveData<List<MovieShow>>()

        remoteDataSource.getListMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMoviesReceived(moviesResponse: List<MovieShow>?) {
                val listMovie = ArrayList<MovieShow>()
                if (moviesResponse != null) {
                    for (movies in moviesResponse) {
                        movies.apply {
                            val movie = MovieShow(id, title, date, image, desc)
                            listMovie.add(movie)
                        }
                    }
                    getMovie.postValue(listMovie)
                }
            }
        })
        return getMovie
    }

    override fun loadTvShow(): LiveData<List<TvShow>> {
        val getTVShow = MutableLiveData<List<TvShow>>()

        remoteDataSource.getListTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTVShowsReceived(tvResponse: List<TvShow>?) {
                val listTVShow = ArrayList<TvShow>()
                if (tvResponse != null) {
                    for (tvShows in tvResponse) {
                        tvShows.apply {
                            val tvShow = TvShow(id, title, date, desc, image)
                            listTVShow.add(tvShow)
                        }
                    }
                    getTVShow.postValue(listTVShow)
                }
            }
        })
        return getTVShow
    }

    override fun loadDetailMovie(movieID: Int): LiveData<DataDetail> {
        val getDetailMovie = MutableLiveData<DataDetail>()

        remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onAllDetailMoviesReceived(moviesDetail: MvDetailResponse?) {
                lateinit var movieDetail: DataDetail
                moviesDetail?.apply {

                    val listGenre = ArrayList<String>()
                    if (genres != null) {
                        for (genre in genres!!) {
                            genre.name?.let { listGenre.add(it) }
                        }
                    }

                    movieDetail = DataDetail(
                            id = id,
                            title = title,
                            date = date,
                            genres = listGenre,
                            imageDetail = imageDetail,
                            desc = desc
                    )
                    getDetailMovie.postValue(movieDetail)
                }
            }
        }, movieID)
        return getDetailMovie
    }

    override fun loadDetailTvShow(tvShowID: Int): LiveData<DataDetail> {
        val getDetailTVShow = MutableLiveData<DataDetail>()

        remoteDataSource.getDetailTVShows(object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onAllDetailTVShowsReceived(tvShowsDetail: TvDetailResponse?) {
                lateinit var tvShowDetail: DataDetail
                tvShowsDetail?.apply {

                    val listGenre = ArrayList<String>()
                    if (genres != null) {
                        for (genre in genres!!) {
                            genre.name?.let { listGenre.add(it) }
                        }
                    }

                    tvShowDetail = DataDetail(
                            id = id,
                            title = title,
                            date = date,
                            genres = listGenre,
                            imageDetail = imageDetail,
                            desc = desc
                    )
                    getDetailTVShow.postValue(tvShowDetail)
                }
            }
        }, tvShowID)
        return getDetailTVShow
    }
}