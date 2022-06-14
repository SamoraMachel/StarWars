package com.example.starwars.domain.models

data class Specie(
    val average_height: String,
    val average_lifespan: String,
    val classification: String,
    val designation: String,
    val eye_colors: String,
    val films: List<String>,
    val hair_colors: String,
    val homeworld: String?,
    val language: String,
    val name: String,
    val people: List<String>,
    val skin_colors: String
)