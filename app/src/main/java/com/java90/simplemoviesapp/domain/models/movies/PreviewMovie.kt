package com.java90.simplemoviesapp.domain.models.movies

data class Movie (
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Int

    //val adult: Boolean,
    //val genre_ids: List<Int>,
    //val original_title: String,
    //val video: Boolean,
    //val vote_count: Int
)