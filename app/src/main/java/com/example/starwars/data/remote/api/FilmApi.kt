package com.example.starwars.data.remote.api

import com.example.starwars.domain.models.Film
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Url

interface FilmApi {
    @GET
    fun fetchSpecificFilm(@Url url : String) : Flow<Film>
}