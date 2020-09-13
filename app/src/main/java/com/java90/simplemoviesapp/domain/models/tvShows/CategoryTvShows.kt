package com.java90.simplemoviesapp.domain.models.series

import com.java90.simplemoviesapp.domain.models.movies.DiscoverMovie

data class CategoryTvShows(
    val categoryTitle: String,
    var categoryItems : List<DiscoverTvShow>
)