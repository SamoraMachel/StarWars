package com.example.starwars.domain.repository

import com.example.starwars.domain.models.Specie
import retrofit2.Response

interface SpecieRepository {
    fun fetchSpecificSpecie() : Response<Specie>
}