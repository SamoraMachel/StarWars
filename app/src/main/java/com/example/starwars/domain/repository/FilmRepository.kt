package com.example.starwars.domain.repository

import com.example.starwars.domain.models.Film
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

interface FilmRepository {
    fun fetchSpecificFilm(url : String) : Call<Film>
}