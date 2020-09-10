package com.java90.simplemoviesapp.interactors

import com.java90.simplemoviesapp.domain.GetAllPreviewMovies
import com.java90.simplemoviesapp.domain.models.movies.CategoryMovies

class CategoryMoviesUseCase (private val getAllPreviewMovies: GetAllPreviewMovies) {

    suspend fun getAllCategoryMovies() : List<CategoryMovies> {
        return getAllPreviewMovies.getAllCategory()
    }
}