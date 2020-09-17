package com.java90.simplemoviesapp.interactors

import com.java90.simplemoviesapp.data.network.NetworkDataSource
import com.java90.simplemoviesapp.domain.models.starts.DetailPerson
import com.java90.simplemoviesapp.domain.models.starts.People
import retrofit2.Response
import javax.inject.Inject

class PeopleUseCase
    @Inject constructor(private val networkDataSource: NetworkDataSource) {

    suspend fun getPopularPeople() : Response<People> {
        return networkDataSource.getPopularPeopleFromNetwork()
    }

    suspend fun getDetailPerson(personId: Int) : Response<DetailPerson> {
        return networkDataSource.getDetailPersonFromNetwork(personId)
    }
}