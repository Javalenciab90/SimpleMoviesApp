package com.java90.simplemoviesapp.interactors

import android.util.Log
import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.domain.models.movies.DetailMovie
import retrofit2.Response
import javax.inject.Inject

class DetailMovieUseCase
    @Inject constructor(private val networkDataSource: NetworkDataSource) {

    suspend fun getMovieDetails(movieId: Int) : Response<DetailMovie> {
        return networkDataSource.getMovieDetailsFromNetwork(movieId)
    }
}