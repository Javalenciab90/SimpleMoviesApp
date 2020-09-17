package com.java90.simplemoviesapp.domain.models.tvShows

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiscoverTvShow(

    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("poster_path")
    @Expose
    val poster_path: String,
    @SerializedName("vote_average")
    @Expose
    val vote_average: Double,
    @SerializedName("overview")
    @Expose
    val overview: String,
    @SerializedName("first_air_date")
    @Expose
    val first_air_date: String,
    @SerializedName("original_language")
    @Expose
    val original_language: String

) : Parcelable