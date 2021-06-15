package com.nurdin.submission1jetpackpro.data.remote

import androidx.lifecycle.LiveData
import com.nurdin.submission1jetpackpro.data.response.MovieShow
import com.nurdin.submission1jetpackpro.data.response.TvShow
import com.nurdin.submission1jetpackpro.model.DataDetail

interface ShowDS {
    fun loadMovie(): LiveData<List<MovieShow>>

    fun loadDetailMovie(movieID: Int): LiveData<DataDetail>

    fun loadTvShow(): LiveData<List<TvShow>>

    fun loadDetailTvShow(tvShowID: Int): LiveData<DataDetail>
}