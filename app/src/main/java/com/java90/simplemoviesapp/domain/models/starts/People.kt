package com.java90.simplemoviesapp.domain.models.starts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class People(

    @SerializedName("results")
    @Expose
    val results: List<Person>

)