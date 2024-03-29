package com.example.starwars.app.models

data class SpeciePresentation(
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
