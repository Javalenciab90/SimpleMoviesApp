package com.java90.simplemoviesapp.domain.models.movies

// Model for List of PreviewMovies filter by genre
data class GenreMovies2(
    val page: Int,
    val results: List<PreviewMovie>,
    val total_pages: Int,
    val total_results: Int
)