package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Specie
import com.example.starwars.domain.repository.SpecieRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

private typealias specificSpecieBaseUseCase = DataBaseCase<String, Call<Specie>>

class FetchSpecificSpecieUseCase(private val specieRepository: SpecieRepository) : specificSpecieBaseUseCase {
    override suspend fun execute(params : String): Call<Specie> {
        return specieRepository.fetchSpecificSpecie(params)
    }
}