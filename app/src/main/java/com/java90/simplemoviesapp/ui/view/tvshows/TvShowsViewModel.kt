package com.java90.simplemoviesapp.ui.view.tvShows

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.java90.simplemoviesapp.domain.models.tvShows.CategoryTvShows
import com.java90.simplemoviesapp.domain.utils.Resource
import com.java90.simplemoviesapp.interactors.CategoryTvShowsUseCase
import kotlinx.coroutines.launch

class TvShowsViewModel @ViewModelInject constructor(
    private val categoryTvShowsUseCase: CategoryTvShowsUseCase): ViewModel() {

    val tvShowByCategory : MutableLiveData<Resource<List<CategoryTvShows>>> = MutableLiveData()

    init {
        getAllCategoryPreviewTvShow()
    }

    fun getAllCategoryPreviewTvShow() = viewModelScope.launch {
        tvShowByCategory.postValue(Resource.Loading())
        try {
            val response = categoryTvShowsUseCase.getAllCategoryTvShows()
            Log.d("TAG", response.toString())
            tvShowByCategory.postValue(Resource.Success(response))
        } catch (e:Exception) {
            tvShowByCategory.postValue(Resource.Failure(e.message.toString()))
        }
    }
}