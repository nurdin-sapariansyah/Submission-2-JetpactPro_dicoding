package com.nurdin.submission1jetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nurdin.submission1jetpackpro.data.remote.ShowRepository
import com.nurdin.submission1jetpackpro.data.response.MovieShow
import com.nurdin.submission1jetpackpro.data.response.TvShow

class ContentViewModel(private val showRepository: ShowRepository) : ViewModel() {

    fun getListMovie(): LiveData<List<MovieShow>> = showRepository.loadMovie()

    fun getListTvShow(): LiveData<List<TvShow>> = showRepository.loadTvShow()
}