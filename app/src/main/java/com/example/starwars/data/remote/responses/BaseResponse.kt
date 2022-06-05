package com.example.starwars.data.remote.responses

data class BaseResponse<T>(
    val count : Int,
    val next : String?,
    val previous : String?,
    val result : List<T>
)