package com.java90.simplemoviesapp.di

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.domain.SetAllPreviewTvShows
import com.java90.simplemoviesapp.interactors.CategoryMoviesUseCase
import com.java90.simplemoviesapp.interactors.CategoryTvShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object TvShowsModule {

    @Singleton
    @Provides
    fun provideAllPreviewTvShows(networkDataSource: NetworkDataSource) : SetAllPreviewTvShows {
        return SetAllPreviewTvShows(networkDataSource)
    }

    @Singleton
    @Provides
    fun provideCategoryTvShowsUseCase(
        setAllPreviewTvShows: SetAllPreviewTvShows) : CategoryTvShowsUseCase {

        return CategoryTvShowsUseCase(setAllPreviewTvShows)
    }
}