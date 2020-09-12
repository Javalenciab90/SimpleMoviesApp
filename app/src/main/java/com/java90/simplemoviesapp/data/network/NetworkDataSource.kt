package com.java90.simplemoviesapp.data.network

import com.java90.simplemoviesapp.domain.models.movies.DetailMovie
import com.java90.simplemoviesapp.domain.models.movies.GenreMovies
import retrofit2.Response

interface NetworkDataSource {

    suspend fun getMoviesByGenreFromNetwork(genreId: Int) : Response<GenreMovies>

    suspend fun getMovieDetailsFromNetwork(movieId: Int) : Response<DetailMovie>
}

