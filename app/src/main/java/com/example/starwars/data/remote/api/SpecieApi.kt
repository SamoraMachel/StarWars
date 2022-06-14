package com.example.starwars.data.remote.api

import com.example.starwars.domain.models.Specie
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface SpecieApi {
    @GET
    fun fetchSpecificSpecie(@Url url : String) : Call<Specie>
}