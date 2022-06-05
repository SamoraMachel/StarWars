package com.example.starwars.data.remote.mappers

import com.example.starwars.data.remote.models.PeopleNetwork
import com.example.starwars.data.remote.models.StarshipNetwork
import com.example.starwars.domain.models.People
import com.example.starwars.domain.models.Starship


fun PeopleNetwork.toDomain() : People {
    return People(
        birthYear,
        eyeColor,
        films,
        gender,
        hairColor,
        height,
        homeWorld,
        mass,
        name,
        skinColor,
        species as List<String?>,
        starships,
        vehicles
    )
}

fun StarshipNetwork.toDomain() : Starship {
    return Starship(
        MGLT.toInt(),
        cargoCapacity.toInt(),
        consumables,
        costInCredits.toInt(),
        crew,
        films,
        hyperDriveRating.toDouble(),
        length.toInt(),
        manufacturer,
        maxAtmospheringSpeed.toInt(),
        model,
        name,
        passengers.toInt(),
        pilots as List<String?>,
        starshipClass
    )
}
