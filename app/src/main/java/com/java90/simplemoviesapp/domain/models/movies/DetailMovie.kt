package com.java90.simplemoviesapp.domain.models.movies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailMovie (

    @SerializedName("backdrop_path")
    @Expose
    val backdrop_path: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("overview")
    @Expose
    val overview: String,
    @SerializedName("poster_path")
    @Expose
    val poster_path: String,
    @SerializedName("release_date")
    @Expose
    val release_date: String,
    @SerializedName("runtime")
    @Expose
    val runtime: Int,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("vote_average")
    @Expose
    val vote_average: Double,
    @SerializedName("original_language")
    @Expose
    val original_language: String

    //val popularity: Double,
    //val original_language: String
    //val revenue: Int,
    //val adult: Boolean,
    //val spoken_languages: List<SpokenLanguage>,
    //val vote_count: Int,
    //val video: Boolean,
    //val tagline: String,
    //val belongs_to_collection: Any,
    //val budget: Int,
    //val genres: List<Genre>,
    //val homepage: String,
    //val imdb_id: String,
    //val original_title: String,
    //val production_companies: List<ProductionCompany>,
    //val production_countries: List<ProductionCountry>,
)