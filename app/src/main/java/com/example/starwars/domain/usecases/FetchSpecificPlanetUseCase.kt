package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Planet
import com.example.starwars.domain.repository.PlanetRepository
import kotlinx.coroutines.flow.Flow

typealias fetchSpecieUseCase = DataBaseCase<String, Flow<Planet>>

class FetchSpecificPlanetUseCase constructor(private val planetRepository: PlanetRepository) : fetchSpecieUseCase {
    override suspend fun execute(params : String): Flow<Planet> {
        return planetRepository.fetchPlanet(params)
    }
}