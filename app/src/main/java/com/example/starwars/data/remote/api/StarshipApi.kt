package com.example.starwars.data.remote.api

import com.example.starwars.data.remote.models.StarshipNetwork
import com.example.starwars.data.remote.responses.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StarshipApi {

    @GET("/starships/")
    suspend fun fetchStarships(@Query("page") page : Int) : BaseResponse<StarshipNetwork>

}