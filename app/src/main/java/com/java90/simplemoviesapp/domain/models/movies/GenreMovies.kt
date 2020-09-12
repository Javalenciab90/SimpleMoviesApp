package com.java90.simplemoviesapp.domain.models.movies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Model for List of DiscoverMovies filter by genre

data class GenreMovies(

    @SerializedName("results")
    @Expose
    val results: List<DiscoverMovie>

    //val page: Int,
    //val total_pages: Int,
    //val total_results: Int
)