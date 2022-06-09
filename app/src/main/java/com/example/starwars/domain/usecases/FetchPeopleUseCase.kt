package com.example.starwars.domain.usecases

import android.util.Log
import androidx.paging.PagingData
import com.example.starwars.domain.models.People
import com.example.starwars.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow

private typealias FetchPeopleBaseUseCase = BaseUseCase<Flow<PagingData<People>>>

class FetchPeopleUseCase constructor(private val peopleRepository: PeopleRepository) :
    FetchPeopleBaseUseCase {
    override suspend fun execute(): Flow<PagingData<People>> {
        Log.d("FetchPeopleUseCase", "execute: People Data fetched")
        return peopleRepository.fetchPeople()
    }

}