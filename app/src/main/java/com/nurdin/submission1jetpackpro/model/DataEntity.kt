package com.nurdin.submission1jetpackpro.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntity(
    var id: Int,
    var title: String,
    var description: String,
    var genre: List<Genres>,
    var realeased: String,
    var imgPoster: String
) : Parcelable

@Parcelize
data class Genres (
    val name: String? = ""
) : Parcelable