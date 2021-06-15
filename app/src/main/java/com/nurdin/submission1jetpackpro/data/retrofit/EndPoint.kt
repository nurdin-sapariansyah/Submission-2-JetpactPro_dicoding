package com.nurdin.submission1jetpackpro.data.retrofit

import com.nurdin.submission1jetpackpro.data.response.MvDetailResponse
import com.nurdin.submission1jetpackpro.data.response.MvResponse
import com.nurdin.submission1jetpackpro.data.response.TvDetailResponse
import com.nurdin.submission1jetpackpro.data.response.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoint {
    @GET("movie/now_playing?api_key=136960271ba4ed137f06400a7eb7e86a")
    fun getMovie(): Call<MvResponse>

    @GET("movie/{movie_id}?api_key=136960271ba4ed137f06400a7eb7e86a")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
    ): Call<MvDetailResponse>

    @GET("tv/popular?api_key=136960271ba4ed137f06400a7eb7e86a")
    fun getTvShow(
    ): Call<TvResponse>

    @GET("tv/{tv_id}?api_key=136960271ba4ed137f06400a7eb7e86a")
    fun getDetailTvShow(
        @Path("tv_id") tvId: Int,
    ): Call<TvDetailResponse>
}