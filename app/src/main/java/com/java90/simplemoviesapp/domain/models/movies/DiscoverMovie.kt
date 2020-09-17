package com.java90.simplemoviesapp.domain.models.movies

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiscoverMovie (

    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("poster_path")
    @Expose
    val poster_path: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("backdrop_path")
    @Expose
    val backdrop_path: String,
    @SerializedName("vote_average")
    @Expose
    val vote_average: Double,
    @SerializedName("original_language")
    @Expose
    val original_language: String,
    @SerializedName("release_date")
    @Expose
    val release_date: String,
    @SerializedName("overview")
    @Expose
    val overview: String

) : Parcelable