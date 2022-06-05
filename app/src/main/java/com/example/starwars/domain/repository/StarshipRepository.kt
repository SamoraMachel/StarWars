package com.example.starwars.domain.repository

import androidx.paging.PagingData
import com.example.starwars.domain.models.Starship
import kotlinx.coroutines.flow.Flow

interface StarshipRepository {
    fun fetchStarships() : Flow<PagingData<Starship>>
}