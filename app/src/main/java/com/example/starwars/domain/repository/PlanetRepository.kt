package com.example.starwars.domain.repository

import com.example.starwars.domain.models.Planet
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

interface PlanetRepository {
    fun fetchPlanet(url : String) : Call<Planet>

}