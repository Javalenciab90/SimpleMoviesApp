package com.java90.simplemoviesapp.framwork.api

import com.java90.simplemoviesapp.domain.models.movies.GenreMovies
import com.java90.simplemoviesapp.domain.models.starts.DetailPerson
import com.java90.simplemoviesapp.domain.models.starts.People
import com.java90.simplemoviesapp.domain.models.tvShows.GenreTvShow
import com.java90.simplemoviesapp.domain.utils.Constants.Companion.THE_MOVIE_DB_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres")
        genre : Int,
        @Query("api_key")
        api_key: String = THE_MOVIE_DB_API_KEY,
        @Query("language")
        language : String = "en-US",
        @Query("sort_by")
        sort_by : String = "popularity.desc",
        @Query("include_adult")
        include_adult : Boolean = false,
        @Query("include_video")
        include_video : Boolean = false,
        @Query("page")
        pageNumber : Int = 1

    ) : Response<GenreMovies>


    @GET("discover/tv")
    suspend fun getTvShowsByGenre(
        @Query("with_genres")
        genre : Int,
        @Query("api_key")
        api_key: String = THE_MOVIE_DB_API_KEY,
        @Query("language")
        language : String = "en-US",
        @Query("sort_by")
        sort_by : String = "popularity.desc",
        @Query("timezone")
        timezone : String = "America%/2FNew_York",
        @Query("include_null_first_air_dates")
        include_null_first_air_dates : Boolean = false,
        @Query("page")
        pageNumber : Int = 1

    ) : Response<GenreTvShow>

    @GET("person/popular")
    suspend fun getPopularPersons(
        @Query("api_key")
        api_key: String = THE_MOVIE_DB_API_KEY,
        @Query("language")
        language : String = "en-US",
        @Query("page")
        pageNumber : Int = 1

    ) : Response<People>

    @GET("person/{person_id}")
    suspend fun getDetailPerson(
        @Path("person_id")
        id: Int,
        @Query("api_key")
        api_key: String = THE_MOVIE_DB_API_KEY,
        @Query("language")
        language : String = "en-US"
    ) : Response<DetailPerson>

}