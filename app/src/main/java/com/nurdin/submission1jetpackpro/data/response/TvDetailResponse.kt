package com.nurdin.submission1jetpackpro.data.response

import com.google.gson.annotations.SerializedName

data class TvDetailResponse(
        @SerializedName("poster_path")
        val imageDetail: String? = null,

        @SerializedName("original_name")
        val title: String? = null,

        @SerializedName("overview")
        val desc: String? = null,

        @SerializedName("genres")
        val genres: List<GenreResponse>? = null,

        @SerializedName("first_air_date")
        val date: String? = null,

        @SerializedName("id")
        val id: Int? = null,
)