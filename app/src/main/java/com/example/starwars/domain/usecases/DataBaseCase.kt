package com.example.starwars.domain.usecases

interface DataBaseCase<in P, out T> {
    suspend fun execute(params: P): T
}