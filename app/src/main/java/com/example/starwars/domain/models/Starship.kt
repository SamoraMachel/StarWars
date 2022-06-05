package com.example.starwars.domain.models

import androidx.annotation.Nullable

data class Starship(
    val mglt: Int,
    val cargo_capacity: Int,
    val consumables: String,
    val cost_in_credits: Int,
    val created: String,
    val crew: String,
    val edited: String,
    val films: List<String>,
    val hyperdrive_rating: Double,
    val length: Int,
    val manufacturer: String,
    val max_atmosphering_speed: Int,
    val model: String,
    val name: String,
    val passengers: Int,
    @Nullable
    val pilots: List<String?>?,
    val starship_class: String,
    val url: String
)