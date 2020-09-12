package com.java90.simplemoviesapp.di

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.data.network.NetworkDataSourceImpl
import com.java90.simplemoviesapp.domain.SetAllPreviewMovies
import com.java90.simplemoviesapp.framwork.api.ApiService
import com.java90.simplemoviesapp.interactors.CategoryMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MoviesModule {

    @Singleton
    @Provides
    fun provideNetworkDataSource(apiService: ApiService) : NetworkDataSource {
        return NetworkDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideAllPreviewMovies(networkDataSource: NetworkDataSource) : SetAllPreviewMovies {
        return SetAllPreviewMovies(networkDataSource)
    }

    @Singleton
    @Provides
    fun provideCategoryMoviesUseCase(
        setAllPreviewMovies: SetAllPreviewMovies) : CategoryMoviesUseCase {

        return CategoryMoviesUseCase(setAllPreviewMovies)
    }
}