package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Specie
import com.example.starwars.domain.repository.SpecieRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

private typealias specificSpecieBaseUseCase = BaseUseCase<Flow<Specie>>

class FetchSpecificSpecieUseCas(private val specieRepository: SpecieRepository) : specificSpecieBaseUseCase {
    override suspend fun execute(): Flow<Specie> {
        return specieRepository.fetchSpecificSpecie()
    }
}