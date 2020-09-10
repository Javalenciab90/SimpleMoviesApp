package com.java90.simplemoviesapp.domain.models

import com.java90.simplemoviesapp.domain.models.movies.PreviewMovie


data class Category(
    val categoryTitle: String,
    var categoryItems : List<PreviewMovie>
)