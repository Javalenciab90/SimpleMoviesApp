package com.java90.simplemoviesapp.domain.models.starts

data class People(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)