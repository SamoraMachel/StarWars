package com.example.starwars.data.remote.api

import com.example.starwars.domain.models.Planet
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PlanetApi {
    @GET
    fun fetchSpecificPlanet(@Url url : String) : Response<Planet>
}