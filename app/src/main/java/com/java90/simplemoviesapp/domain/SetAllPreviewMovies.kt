package com.java90.simplemoviesapp.domain

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.domain.models.movies.CategoryMovies
import com.java90.simplemoviesapp.domain.models.movies.DiscoverMovie
import com.java90.simplemoviesapp.domain.utils.MoviesGenre
import javax.inject.Inject

/*
    - Get each category(Genre) movie list and save them in one list
    - To add more Genres just add to Enum Class Genres the name and id.
 */

class SetAllPreviewMovies
    @Inject constructor(private val networkDataSource: NetworkDataSource) {

    private suspend fun getAllMoviesByGenre(genreId: Int) : List<DiscoverMovie> {

        var moviesByGenre : List<DiscoverMovie> = ArrayList()

        val moviesResponse = networkDataSource.getMoviesByGenreFromNetwork(genreId)
        if(moviesResponse.isSuccessful) {
            moviesResponse.body()?.let { genreMovies ->
                moviesByGenre = genreMovies.results
            }
        }
        return moviesByGenre
    }

    suspend fun setAllCategoryOnList () : List<CategoryMovies>{

        val allCategory : MutableList<CategoryMovies> = ArrayList()

        allCategory.add(
            CategoryMovies("Action", getAllMoviesByGenre(MoviesGenre.ACTION.getNumber()))
        )

        allCategory.add(
            CategoryMovies("Romance", getAllMoviesByGenre(MoviesGenre.ROMANCE.getNumber()))
        )

        allCategory.add(
            CategoryMovies("Science Fiction", getAllMoviesByGenre(MoviesGenre.SCIENCE_FICTION.getNumber()))
        )

        return allCategory
    }
}