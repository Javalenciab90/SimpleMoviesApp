package com.java90.simplemoviesapp.di

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.interactors.PeopleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PeopleModule {

    @Singleton
    @Provides
    fun providePeopleUseCase(networkDataSource: NetworkDataSource) : PeopleUseCase {
        return PeopleUseCase(networkDataSource)
    }
}