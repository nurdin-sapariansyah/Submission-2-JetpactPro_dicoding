package com.nurdin.submission1jetpackpro.data.response

import com.google.gson.annotations.SerializedName

data class TvResponse(
    @field:SerializedName("results")
    val result: List<TvShow>
)

data class TvShow(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val title: String,

    @SerializedName("first_air_date")
    val date: String,

    @SerializedName("overview")
    val desc: String,

    @SerializedName("poster_path")
    val image: String
)