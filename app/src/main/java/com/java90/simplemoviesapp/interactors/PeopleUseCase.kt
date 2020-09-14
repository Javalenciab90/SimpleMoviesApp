package com.java90.simplemoviesapp.interactors

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.domain.models.starts.People
import retrofit2.Response
import javax.inject.Inject

class PopularPeopleUseCase
    @Inject constructor(private val networkDataSource: NetworkDataSource) {

    suspend fun getPopularPeople() : Response<People> {
        return networkDataSource.getPopularPeopleFromNetwork()
    }
}