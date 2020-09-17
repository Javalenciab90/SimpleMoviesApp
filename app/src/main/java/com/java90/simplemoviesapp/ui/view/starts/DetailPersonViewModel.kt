package com.java90.simplemoviesapp.ui.view.starts

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.java90.simplemoviesapp.domain.models.starts.DetailPerson
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.interactors.PeopleUseCase
import kotlinx.coroutines.launch

class DetailPersonViewModel
    @ViewModelInject constructor(private val peopleUseCase: PeopleUseCase): ViewModel() {

    val loadDetailPerson : MutableLiveData<Resource<DetailPerson>> = MutableLiveData()

    fun getDetailPerson(personId: Int) = viewModelScope.launch{

        loadDetailPerson.postValue(Resource.Loading())

        try {
            val response = peopleUseCase.getDetailPerson(personId)
            if (response.isSuccessful) {
                response.body()?.let {
                    loadDetailPerson.postValue(Resource.Success(it))
                }
            }
        }catch (e: Exception) {
            loadDetailPerson.postValue(Resource.Failure(e.message.toString()))
        }
    }
}