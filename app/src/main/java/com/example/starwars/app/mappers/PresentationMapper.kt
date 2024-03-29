package com.example.starwars.app.mappers

import com.example.starwars.app.models.*
import com.example.starwars.domain.models.*

class PresentationMapper {
    companion object {
        fun peopleDomainMapper(peoplePresentation : PeoplePresentation) : People {
            return People(
                peoplePresentation.birthYear,
                peoplePresentation.eyeColor,
                peoplePresentation.films,
                peoplePresentation.gender,
                peoplePresentation.hairColor,
                peoplePresentation.height,
                peoplePresentation.homeWorld,
                peoplePresentation.mass,
                peoplePresentation.name,
                peoplePresentation.skinColor,
                peoplePresentation.species,
                peoplePresentation.starships,
                peoplePresentation.vehicles
            )
        }

        fun peoplePresentationMapper(peopleDomain : People) : PeoplePresentation {
            return PeoplePresentation(
                peopleDomain.birthYear,
                peopleDomain.eyeColor,
                peopleDomain.films,
                peopleDomain.gender,
                peopleDomain.hairColor,
                peopleDomain.height,
                peopleDomain.homeWorld,
                peopleDomain.mass,
                peopleDomain.name,
                peopleDomain.skinColor,
                peopleDomain.species as List<String?>,
                peopleDomain.starships,
                peopleDomain.vehicles
            )
        }

        fun speciePresentationMapper(specieDomain : Specie) : SpeciePresentation {
            return SpeciePresentation(
                specieDomain.average_height,
                specieDomain.average_lifespan,
                specieDomain.classification,
                specieDomain.designation,
                specieDomain.eye_colors,
                specieDomain.films,
                specieDomain.hair_colors,
                specieDomain.homeworld,
                specieDomain.language,
                specieDomain.name,
                specieDomain.people,
                specieDomain.skin_colors
            )
        }

        fun planetPresentationMapper(planetDomain : Planet) : PlanetPresentation {
            return PlanetPresentation(
                planetDomain.climate,
                planetDomain.diameter,
                planetDomain.films,
                planetDomain.gravity,
                planetDomain.name,
                planetDomain.orbital_period,
                planetDomain.population,
                planetDomain.residents,
                planetDomain.rotation_period,
                planetDomain.surface_water,
                planetDomain.terrain
            )
        }

        fun filmPresentationMapper(filmDomain : Film) : FilmPresentation {
            return FilmPresentation(
                filmDomain.characters,
                filmDomain.director,
                filmDomain.episode_id,
                filmDomain.opening_crawl,
                filmDomain.planets,
                filmDomain.producer,
                filmDomain.release_date,
                filmDomain.species,
                filmDomain.starships,
                filmDomain.title,
                filmDomain.vehicles
            )
        }

        fun starshipDomainMapper(starshipPresentation : StarshipPresentation) : Starship {
            return Starship(
                starshipPresentation.mglt.toInt(),
                starshipPresentation.cargoCapacity.toInt(),
                starshipPresentation.consumables,
                starshipPresentation.costInCredits.toInt(),
                starshipPresentation.crew,
                starshipPresentation.films,
                starshipPresentation.hyperDriveRating.toDouble(),
                starshipPresentation.length.toInt(),
                starshipPresentation.manufacturer,
                starshipPresentation.maxAtmospheringSpeed.toInt(),
                starshipPresentation.model,
                starshipPresentation.name,
                starshipPresentation.passengers.toInt(),
                starshipPresentation.pilots as List<String?>,
                starshipPresentation.starshipClass
            )
        }
     }
}