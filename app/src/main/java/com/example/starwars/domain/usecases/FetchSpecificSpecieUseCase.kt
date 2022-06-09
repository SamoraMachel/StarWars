package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Specie
import com.example.starwars.domain.repository.SpecieRepository
import retrofit2.Response

private typealias specificSpecieBaseUseCase = BaseUseCase<Response<Specie>>

class FetchSpecificSpecieUseCas(private val specieRepository: SpecieRepository) : specificSpecieBaseUseCase {
    override suspend fun execute(): Response<Specie> {
        return specieRepository.fetchSpecificSpecie()
    }
}