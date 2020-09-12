package com.java90.simplemoviesapp.domain.models.movies

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// DiscoverMovie -> Previews movie poster to show in MoviesFragment

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

    //val adult: Boolean,
    //val backdrop_path: String,
    //val genre_ids: List<Int>,
    //val video: Boolean,
    //val vote_average: Double,
    //val vote_count: Int,
    //val original_language: String,
    //val original_title: String,
    //val overview: String,
    //val popularity: Double,
    //val release_date: String,
) : Parcelable