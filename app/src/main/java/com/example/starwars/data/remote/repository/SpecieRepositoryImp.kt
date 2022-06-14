package com.example.starwars.data.remote.repository

import com.example.starwars.data.remote.api.SpecieApi
import com.example.starwars.data.remote.api.buildRetrofitService
import com.example.starwars.domain.models.Specie
import com.example.starwars.domain.repository.SpecieRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class SpecieRepositoryImp : SpecieRepository {
    override fun fetchSpecificSpecie(url: String): Response<Specie> {
        val specieService = buildRetrofitService(SpecieApi::class.java)
        return specieService.fetchSpecificSpecie(url)
    }
}