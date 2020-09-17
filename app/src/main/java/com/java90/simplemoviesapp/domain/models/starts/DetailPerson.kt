package com.java90.simplemoviesapp.domain.models.starts

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class DetailPerson(

    @SerializedName("biography")
    @Expose
    val biography: String,
    @SerializedName("biograph")
    @Expose
    val biograph: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("place_of_birth")
    @Expose
    val place_of_birth: String,
    @SerializedName("profile_path")
    @Expose
    val profile_path: String
)