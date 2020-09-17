package com.java90.simplemoviesapp.data.network

import com.java90.simplemoviesapp.domain.models.movies.GenreMovies
import com.java90.simplemoviesapp.domain.models.starts.DetailPerson
import com.java90.simplemoviesapp.domain.models.starts.People
import com.java90.simplemoviesapp.domain.models.tvShows.GenreTvShow
import retrofit2.Response

interface NetworkDataSource {

    suspend fun getMoviesByGenreFromNetwork(genreId: Int) : Response<GenreMovies>

    suspend fun getTvShowByGenreFromNetwork(genreId: Int) : Response<GenreTvShow>

    suspend fun getPopularPeopleFromNetwork() : Response<People>

    suspend fun getDetailPersonFromNetwork(personId: Int) : Response<DetailPerson>

}

