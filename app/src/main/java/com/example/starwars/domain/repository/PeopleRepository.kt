package com.example.starwars.domain.repository

import androidx.paging.PagingData
import com.example.starwars.data.remote.models.PeopleNetwork
import com.example.starwars.domain.models.People
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    fun fetchPeople() : Flow<PagingData<People>>
}