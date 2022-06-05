package com.example.starwars.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val WEBSITE_URL = "https://swapi.dev/api/"

private val retrofit = Retrofit.Builder()
    .baseUrl(WEBSITE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun <T> buildRetrofitService(serviceType : Class<T>) : T {
    return retrofit.create(serviceType)
}