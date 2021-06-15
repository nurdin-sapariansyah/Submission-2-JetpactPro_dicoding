package com.nurdin.submission1jetpackpro.data.response

import com.google.gson.annotations.SerializedName

data class MvResponse(
    @field:SerializedName("results")
    val result: List<MovieShow>
)

data class MovieShow(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("release_date")
    val date: String,

    @SerializedName("poster_path")
    val image: String,

    @SerializedName("overview")
    val desc: String
)