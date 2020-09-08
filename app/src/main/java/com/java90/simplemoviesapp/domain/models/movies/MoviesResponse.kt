package com.java90.simplemoviesapp.domain.models.movies

data class ResponseMovies(
    val page: Int,
    val results: List<Movie>,
    //val total_pages: Int,
    //val total_results: Int
)