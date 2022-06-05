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

class NetworkMapper {
    companion object {
        fun peopleNetworkMapper(peopleNetwork: PeopleNetwork) : People {
            return People(
                peopleNetwork.birthYear,
                peopleNetwork.eyeColor,
                peopleNetwork.films,
                peopleNetwork.gender,
                peopleNetwork.hairColor,
                peopleNetwork.height,
                peopleNetwork.homeWorld,
                peopleNetwork.mass,
                peopleNetwork.name,
                peopleNetwork.skinColor,
                peopleNetwork.species as List<String?>,
                peopleNetwork.starships,
                peopleNetwork.vehicles
            )
        }
        fun starshipNetworkMapper(starshipNetwork: StarshipNetwork) : Starship{
            return Starship(
                starshipNetwork.MGLT.toInt(),
                starshipNetwork.cargoCapacity.toInt(),
                starshipNetwork.consumables,
                starshipNetwork.costInCredits.toInt(),
                starshipNetwork.crew,
                starshipNetwork.films,
                starshipNetwork.hyperDriveRating.toDouble(),
                starshipNetwork.length.toInt(),
                starshipNetwork.manufacturer,
                starshipNetwork.maxAtmospheringSpeed.toInt(),
                starshipNetwork.model,
                starshipNetwork.name,
                starshipNetwork.passengers.toInt(),
                starshipNetwork.pilots as List<String?>,
                starshipNetwork.starshipClass
            )
        }
    }

}
