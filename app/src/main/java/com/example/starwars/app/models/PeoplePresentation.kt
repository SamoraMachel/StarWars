package com.example.starwars.app.models

import android.os.Parcelable
import androidx.annotation.Nullable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeoplePresentation(
    val birthYear: String,
    val eyeColor: String,
    val films: List<String>,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeWorld: String,
    val mass: String,
    val name: String,
    val skinColor: String,
    @Nullable
    val species: List<String?>?,
    val starships: List<String>,
    val vehicles: List<String>
) : Parcelable