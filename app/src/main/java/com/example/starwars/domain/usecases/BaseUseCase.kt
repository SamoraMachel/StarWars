package com.example.starwars.domain.usecases

interface BaseUseCase<T> {
    fun execute() : T
}