package com.example.starwars.domain.usecases

interface BaseUseCase<out T> {
    suspend fun execute() : T
}