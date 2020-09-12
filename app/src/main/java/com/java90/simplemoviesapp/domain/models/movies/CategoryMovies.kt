package com.java90.simplemoviesapp.domain.models.movies


data class CategoryMovies(
    val categoryTitle: String,
    var categoryItems : List<DiscoverMovie>
)