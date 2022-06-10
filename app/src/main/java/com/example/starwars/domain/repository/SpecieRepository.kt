package com.example.starwars.domain.repository

import com.example.starwars.domain.models.Specie
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SpecieRepository {
    fun fetchSpecificSpecie(url : String) : Flow<Specie>
}