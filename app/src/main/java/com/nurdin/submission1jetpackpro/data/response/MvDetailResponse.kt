package com.nurdin.submission1jetpackpro.data.response

import com.google.gson.annotations.SerializedName

data class MvDetailResponse(
        @SerializedName("poster_path")
        val imageDetail: String? = null,

        @SerializedName("title")
        val title: String? = null,

        @SerializedName("overview")
        val desc: String? = null,

        @SerializedName("genres")
        val genres: List<GenreResponse>? = null,

        @SerializedName("release_date")
        val date: String? = null,

        @SerializedName("id")
        val id: Int? = null,
)

data class GenreResponse(
        @SerializedName("name")
        val name: String?
)