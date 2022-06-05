package com.example.starwars.app.models

import android.os.Parcelable
import androidx.annotation.Nullable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StarshipPresentation(
    val mglt: Int,
    val cargoCapacity: Int,
    val consumables: String,
    val costInCredits: Int,
    val crew: String,
    val films: List<String>,
    val hyperDriveRating: Double,
    val length: Int,
    val manufacturer: String,
    val maxAtmospheringSpeed: Int,
    val model: String,
    val name: String,
    val passengers: Int,
    @Nullable
    val pilots: List<String?>?,
    val starshipClass: String,
) : Parcelable