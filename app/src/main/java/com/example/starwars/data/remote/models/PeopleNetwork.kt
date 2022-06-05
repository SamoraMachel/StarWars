package com.example.starwars.data.remote.models

import com.google.gson.annotations.SerializedName

data class PeopleNetwork(
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    val films: List<String>,
    val gender: String,
    @SerializedName("hair_color")
    val hairColor: String,
    val height: String,
    @SerializedName("homeworld")
    val homeWorld: String,
    val mass: String,
    val name: String,
    @SerializedName("skin_color")
    val skinColor: String,
    val species: List<Any>,
    val starships: List<String>,
    val vehicles: List<String>
)