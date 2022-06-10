package com.example.starwars.domain.repository

import com.example.starwars.domain.models.Planet
import kotlinx.coroutines.flow.Flow

interface PlanetRepository {
    fun fetchPlanet(url : String) : Flow<Planet>
}