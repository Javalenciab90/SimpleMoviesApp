package com.java90.simplemoviesapp.domain

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.domain.models.tvShows.CategoryTvShows
import com.java90.simplemoviesapp.domain.models.tvShows.DiscoverTvShow
import com.java90.simplemoviesapp.domain.utils.TvShowsGenre
import javax.inject.Inject

/*
    - Get each category(Genre) tvShow list and save them in one list
    - To add more Genres just add to Enum Class Genres the name and id.
 */

class SetAllPreviewTvShows
    @Inject constructor(private val networkDataSource: NetworkDataSource) {

    private suspend fun getAllTvShowsByGenre(genreId: Int) : List<DiscoverTvShow> {

        var tvShowsByGenre : List<DiscoverTvShow> = ArrayList()

        val tvShowsResponse = networkDataSource.getTvShowByGenreFromNetwork(genreId)
        if(tvShowsResponse.isSuccessful) {
            tvShowsResponse.body()?.let { genreTvShows ->
                tvShowsByGenre = genreTvShows.results
            }
        }
        return tvShowsByGenre
    }

    suspend fun setAllCategoryOnList () : List<CategoryTvShows>{

        val allCategory : MutableList<CategoryTvShows> = ArrayList()

        allCategory.add(
            CategoryTvShows("Drama", getAllTvShowsByGenre(TvShowsGenre.DRAMA.getNumber()))
        )

        allCategory.add(
            CategoryTvShows("Comedy", getAllTvShowsByGenre(TvShowsGenre.COMEDY.getNumber()))
        )

        allCategory.add(
            CategoryTvShows("Kids", getAllTvShowsByGenre(TvShowsGenre.KIDS.getNumber()))
        )

        return allCategory
    }
}