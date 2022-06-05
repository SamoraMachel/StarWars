package com.example.starwars.data.remote.models

import com.google.gson.annotations.SerializedName

data class StarshipNetwork(
    val MGLT: String,
    @SerializedName("cargo_capacity")
    val cargoCapacity: String,
    val consumables: String,
    @SerializedName("cost_in_credits")
    val costInCredits: String,
    val crew: String,
    val films: List<String>,
    @SerializedName("hyperdrive_rating")
    val hyperDriveRating: String,
    val length: String,
    val manufacturer: String,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val pilots: List<Any>,
    @SerializedName("starship_class")
    val starshipClass: String,
)