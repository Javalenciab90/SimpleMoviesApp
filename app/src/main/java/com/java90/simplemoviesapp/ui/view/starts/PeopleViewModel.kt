package com.java90.simplemoviesapp.ui.view.starts

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.java90.simplemoviesapp.domain.models.starts.People
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.interactors.PeopleUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class PeopleViewModel
    @ViewModelInject constructor(private val peopleUseCase: PeopleUseCase) : ViewModel() {

    val popularPeople : MutableLiveData<Resource<People>> = MutableLiveData()

    init {
        getPopularPeople()
    }

    private fun getPopularPeople() = viewModelScope.launch {
        popularPeople.postValue(Resource.Loading())
        try {
            val response = peopleUseCase.getPopularPeople()
            if (response.isSuccessful) {
                response.body()?.let { people->
                    popularPeople.postValue(Resource.Success(people))
                }
            }
        }catch (e: Exception) {
            popularPeople.postValue(Resource.Failure(e.message.toString()))
        }
    }

}