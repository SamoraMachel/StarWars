package com.example.starwars.domain.usecases

import androidx.paging.PagingData
import com.example.starwars.domain.models.People
import com.example.starwars.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow

typealias FetchPeopleBaseUseCase = BaseUseCase<Flow<PagingData<People>>>

class FetchPeopleUseCase constructor(private val peopleRepository: PeopleRepository) :
    FetchPeopleBaseUseCase {
    override fun execute(): Flow<PagingData<People>> {
        return peopleRepository.fetchPeople()
    }

}