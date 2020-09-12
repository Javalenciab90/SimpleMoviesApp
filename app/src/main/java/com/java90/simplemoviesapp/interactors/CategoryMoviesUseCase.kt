package com.java90.simplemoviesapp.interactors

import com.java90.simplemoviesapp.domain.SetAllPreviewMovies
import com.java90.simplemoviesapp.domain.models.movies.CategoryMovies
import javax.inject.Inject

class CategoryMoviesUseCase
    @Inject constructor(private val allPreviewMovies: SetAllPreviewMovies) {

    suspend fun getAllCategoryMovies() : List<CategoryMovies> {
        return allPreviewMovies.setAllCategoryOnList()
    }
}