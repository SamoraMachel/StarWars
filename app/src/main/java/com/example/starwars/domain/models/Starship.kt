package com.example.starwars.domain.models

import androidx.annotation.Nullable

data class Starship(
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
)