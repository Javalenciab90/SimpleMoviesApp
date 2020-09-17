package com.java90.simplemoviesapp.domain.models.tvShows

data class CategoryTvShows(
    val categoryTitle: String,
    var categoryItems : List<DiscoverTvShow>
)