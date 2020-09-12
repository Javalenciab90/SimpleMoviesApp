package com.java90.simplemoviesapp.data.network

import com.java90.simplemoviesapp.domain.models.movies.DetailMovie
import com.java90.simplemoviesapp.domain.models.movies.GenreMovies
import com.java90.simplemoviesapp.framwork.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSourceImpl
    @Inject constructor(private val apiService: ApiService) : NetworkDataSource{

    override suspend fun getMoviesByGenreFromNetwork(genreId: Int): Response<GenreMovies> {
        return apiService.getMoviesByGenre(genreId)
    }

    override suspend fun getMovieDetailsFromNetwork(movieId: Int): Response<DetailMovie> {
        return apiService.getDetailMovie(movieId)
    }

}