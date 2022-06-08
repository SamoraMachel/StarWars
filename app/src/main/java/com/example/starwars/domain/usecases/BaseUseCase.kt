package com.example.starwars.domain.usecases

interface BaseUseCase<T> {
    suspend fun execute() : T
}