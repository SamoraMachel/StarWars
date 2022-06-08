package com.example.starwars.domain.usecases

import androidx.paging.PagingData
import com.example.starwars.domain.models.Starship
import com.example.starwars.domain.repository.StarshipRepository
import kotlinx.coroutines.flow.Flow

typealias FetchStarshipBaseUseCase = BaseUseCase<Flow<PagingData<Starship>>>

class FetchStarshipUseCase constructor(private val starshipRepository: StarshipRepository) : FetchStarshipBaseUseCase {
    override suspend fun execute(): Flow<PagingData<Starship>> {
        return starshipRepository.fetchStarships()
    }
}