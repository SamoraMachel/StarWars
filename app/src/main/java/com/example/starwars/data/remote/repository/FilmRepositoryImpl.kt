package com.example.starwars.data.remote.repository

import com.example.starwars.data.remote.api.FilmApi
import com.example.starwars.data.remote.api.buildRetrofitService
import com.example.starwars.domain.models.Film
import com.example.starwars.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow

class FilmRepositoryImpl : FilmRepository{
    override fun fetchSpecificFilm(url: String): Flow<Film> {
        val filmApi : FilmApi = buildRetrofitService(FilmApi::class.java)
        return filmApi.fetchSpecificFilm(url)
    }
}