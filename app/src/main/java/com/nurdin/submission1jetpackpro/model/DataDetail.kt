package com.nurdin.submission1jetpackpro.model

import com.google.gson.annotations.SerializedName

data class DataDetail(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("release_date")
    val date: String? = null,

    @SerializedName("poster_path")
    val imageDetail: String? = null,

    @SerializedName("overview")
    val desc: String? = null,

    @SerializedName("genres")
    val genres: List<String>? = null
    )