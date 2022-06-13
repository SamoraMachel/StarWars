package com.example.starwars.data.remote.repository

import com.example.starwars.data.remote.api.PlanetApi
import com.example.starwars.data.remote.api.buildRetrofitService
import com.example.starwars.domain.models.Planet
import com.example.starwars.domain.repository.PlanetRepository
import kotlinx.coroutines.flow.Flow

class PlanetRepositoryImp : PlanetRepository {
    override fun fetchPlanet(url: String): Flow<Planet> {
        val planetService : PlanetApi = buildRetrofitService(PlanetApi::class.java)
        return planetService.fetchSpecificPlanet(url)
    }
}