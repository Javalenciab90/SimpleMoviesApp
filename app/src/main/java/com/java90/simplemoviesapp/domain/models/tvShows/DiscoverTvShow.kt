package com.java90.simplemoviesapp.domain.models.series

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DiscoverTvShow(

    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("poster_path")
    @Expose
    val poster_path: String


    //val vote_average: Double,
    //val vote_count: Int,
    //val origin_country: List<String>,
    //val original_language: String,
    //val original_name: String,
    //val overview: String,
    //val popularity: Double,
    //val first_air_date: String,
    //val genre_ids: List<Int>,
)