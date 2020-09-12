package com.java90.simplemoviesapp.ui.view.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.interactors.CategoryMoviesUseCase
import kotlinx.coroutines.Dispatchers

class MoviesViewModel @ViewModelInject constructor(
    private val categoryMoviesUseCase: CategoryMoviesUseCase) : ViewModel() {

    fun getAllCategoryPreviewMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = categoryMoviesUseCase.getAllCategoryMovies()
            emit(Resource.Success(response))
        }catch (e: Exception) {
            emit(Resource.Failure(e.message.toString()))
        }
    }
}