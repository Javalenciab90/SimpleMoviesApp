package com.java90.simplemoviesapp.data.network

import com.java90.simplemoviesapp.domain.models.movies.GenreMovies
import com.java90.simplemoviesapp.domain.models.starts.DetailPerson
import com.java90.simplemoviesapp.domain.models.starts.People
import com.java90.simplemoviesapp.domain.models.tvShows.GenreTvShow
import com.java90.simplemoviesapp.framwork.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSourceImpl
    @Inject constructor(private val apiService: ApiService) : NetworkDataSource{

    override suspend fun getMoviesByGenreFromNetwork(genreId: Int): Response<GenreMovies> {
        return apiService.getMoviesByGenre(genreId)
    }

    override suspend fun getTvShowByGenreFromNetwork(genreId: Int): Response<GenreTvShow> {
        return apiService.getTvShowsByGenre(genreId)
    }

    override suspend fun getPopularPeopleFromNetwork(): Response<People> {
        return apiService.getPopularPersons()
    }

    override suspend fun getDetailPersonFromNetwork(personId: Int): Response<DetailPerson> {
        return apiService.getDetailPerson(personId)
    }


}