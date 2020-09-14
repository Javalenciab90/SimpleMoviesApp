package com.java90.simplemoviesapp.domain.models.starts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("profile_path")
    @Expose
    val profile_path: String
)