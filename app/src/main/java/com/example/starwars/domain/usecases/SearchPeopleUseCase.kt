package com.example.starwars.domain.usecases

import androidx.paging.PagingData
import com.example.starwars.domain.models.People
import com.example.starwars.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow

typealias searchPeopleUseCase = DataBaseCase<String, Flow<PagingData<People>>>

class SearchPeopleUseCase(private val peopleRepository: PeopleRepository) : searchPeopleUseCase {
    override suspend fun execute(params: String): Flow<PagingData<People>> {
        return peopleRepository.searchPeople(params)
    }
}