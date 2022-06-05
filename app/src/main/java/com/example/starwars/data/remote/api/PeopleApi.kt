package com.example.starwars.data.remote.api

import com.example.starwars.data.remote.models.PeopleNetwork
import com.example.starwars.data.remote.responses.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApi {
    @GET("/people")
    suspend fun fetchPeople(@Query("page") page : Int) : BaseResponse<PeopleNetwork>
}