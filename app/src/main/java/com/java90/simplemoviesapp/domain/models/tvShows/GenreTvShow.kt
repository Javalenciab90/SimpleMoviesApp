package com.java90.simplemoviesapp.domain.models.tvShows

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenreTvShow(

    @SerializedName("results")
    @Expose
    val results: List<DiscoverTvShow>

    //val page: Int,
    //val total_pages: Int,
    //val total_results: Int
)