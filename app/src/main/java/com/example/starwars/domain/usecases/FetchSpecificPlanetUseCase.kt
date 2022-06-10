package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Planet
import com.example.starwars.domain.repository.PlanetRepository
import kotlinx.coroutines.flow.Flow

typealias fetchSpecieUseCase = BaseUseCase<Flow<Planet>>

class FetchSpecificPlanetUseCase constructor(private val planetRepository: PlanetRepository) : fetchSpecieUseCase {
    override suspend fun execute(): Flow<Planet> {
        return planetRepository.fetchPlanet()
    }
}