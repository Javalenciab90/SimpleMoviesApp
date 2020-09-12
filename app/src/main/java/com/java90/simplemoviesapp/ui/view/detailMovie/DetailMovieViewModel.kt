package com.java90.simplemoviesapp.ui.view.detailMovie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.interactors.DetailMovieUseCase
import kotlinx.coroutines.Dispatchers

class DetailMovieViewModel
    @ViewModelInject constructor(private val detailMovieUseCase: DetailMovieUseCase): ViewModel() {

    fun getDetailsMovieById(movieId: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = detailMovieUseCase.getMovieDetails(movieId)
            emit(Resource.Success(response))
        }catch (e: Exception) {
            emit(Resource.Failure(e.message.toString()))
        }
    }
}