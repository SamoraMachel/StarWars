package com.example.starwars.domain.repository

import com.example.starwars.domain.models.Film
import retrofit2.Response

interface FilmRepository {
    fun fetchSpecificFilm() : Response<Film>
}