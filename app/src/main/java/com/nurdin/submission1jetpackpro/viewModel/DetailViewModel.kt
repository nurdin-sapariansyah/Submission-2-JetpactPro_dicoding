package com.nurdin.submission1jetpackpro.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nurdin.submission1jetpackpro.data.remote.ShowRepository
import com.nurdin.submission1jetpackpro.model.DataDetail
import com.nurdin.submission1jetpackpro.utils.Helper.MOVIE
import com.nurdin.submission1jetpackpro.utils.Helper.TV_SHOW

class DetailViewModel(private val showRepository: ShowRepository): ViewModel() {

    private lateinit var dataDetail: LiveData<DataDetail>

    fun setDetailFilm(id: Int, choose: String) {
        when(choose) {
            MOVIE -> {
                dataDetail = showRepository.loadDetailMovie(id)
            }
            TV_SHOW -> {
                dataDetail = showRepository.loadDetailTvShow(id)
            }
        }
    }
    fun getDetailData() = dataDetail
}