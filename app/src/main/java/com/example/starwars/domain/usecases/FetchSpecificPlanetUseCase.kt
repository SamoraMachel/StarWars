package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Planet
import com.example.starwars.domain.repository.PlanetRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

typealias fetchSpecieUseCase = DataBaseCase<String, Call<Planet>>

class FetchSpecificPlanetUseCase constructor(private val planetRepository: PlanetRepository) : fetchSpecieUseCase {
    override suspend fun execute(params : String): Call<Planet> {
        return planetRepository.fetchPlanet(params)
    }
}