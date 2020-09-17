package com.java90.simplemoviesapp.ui.view.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.java90.simplemoviesapp.domain.models.movies.CategoryMovies
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.interactors.CategoryMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


class MoviesViewModel @ViewModelInject constructor(
    private val categoryMoviesUseCase: CategoryMoviesUseCase) : ViewModel() {

    val moviesByCategory : MutableLiveData<Resource<List<CategoryMovies>>> = MutableLiveData()

    init {
        getAllCategoryPreviewMovies()
    }

    private fun getAllCategoryPreviewMovies() =viewModelScope.launch {
        moviesByCategory.postValue(Resource.Loading())
        try {
            val response = categoryMoviesUseCase.getAllCategoryMovies()
            moviesByCategory.postValue(Resource.Success(response))
        }catch (e:Exception) {
            moviesByCategory.postValue(Resource.Failure(e.message.toString()))
        }
    }
}