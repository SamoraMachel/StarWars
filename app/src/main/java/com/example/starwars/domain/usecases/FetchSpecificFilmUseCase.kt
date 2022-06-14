package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Film
import com.example.starwars.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

private typealias  fetchSpecificFilmBase = DataBaseCase<String, Response<Film>>

class FetchSpecificFilmUseCase(private val filmRepository: FilmRepository) : fetchSpecificFilmBase {
    override suspend fun execute(params : String): Response<Film> {
        return filmRepository.fetchSpecificFilm(params)
    }
}