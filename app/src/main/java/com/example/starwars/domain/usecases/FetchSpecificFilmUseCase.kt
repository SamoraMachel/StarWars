package com.example.starwars.domain.usecases

import com.example.starwars.domain.models.Film
import com.example.starwars.domain.repository.FilmRepository
import retrofit2.Response

private typealias  fetchSpecificFilmBase = BaseUseCase<Response<Film>>

class FetchSpecificFilmUseCase(private val filmRepository: FilmRepository) : fetchSpecificFilmBase {
    override suspend fun execute(): Response<Film> {
        return filmRepository.fetchSpecificFilm()
    }
}