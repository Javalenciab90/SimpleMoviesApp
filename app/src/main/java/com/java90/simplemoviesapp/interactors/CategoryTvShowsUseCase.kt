package com.java90.simplemoviesapp.interactors

import com.java90.simplemoviesapp.domain.SetAllPreviewTvShows
import com.java90.simplemoviesapp.domain.models.tvShows.CategoryTvShows
import javax.inject.Inject

class CategoryTvShowsUseCase
    @Inject constructor(private val allPreviewTvShows: SetAllPreviewTvShows) {

    suspend fun getAllCategoryTvShows() : List<CategoryTvShows> {
        return allPreviewTvShows.setAllCategoryOnList()
    }
}