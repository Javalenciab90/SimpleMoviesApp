package com.java90.simplemoviesapp.domain

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.domain.models.movies.CategoryMovies
import com.java90.simplemoviesapp.domain.models.movies.PreviewMovie
import com.java90.simplemoviesapp.domain.utils.MoviesGenre
import javax.inject.Inject


class GetAllPreviewMovies
    @Inject constructor(private val networkDataSource: NetworkDataSource) {

    private suspend fun getAllMoviesByGenre(genreId: Int) : List<PreviewMovie> {
        var moviesByGenre : List<PreviewMovie> = ArrayList()
        val moviesResponse = networkDataSource.getMoviesByGenreFromNetwork(genreId)
        if(moviesResponse.isSuccessful) {
            moviesResponse.body()?.let { genreMovies ->
                moviesByGenre = genreMovies.results
            }
        }
        return moviesByGenre
    }

    suspend fun setAllCategory () : List<CategoryMovies>{

        val allCategory : MutableList<CategoryMovies> = ArrayList()

        allCategory.add(
            CategoryMovies("Action", getAllMoviesByGenre(MoviesGenre.ACTION.getNumber()))
        )

        allCategory.add(
            CategoryMovies("Romance", getAllMoviesByGenre(MoviesGenre.ROMANCE.getNumber()))
        )

        return allCategory
    }
}