package com.example.starwars

import com.example.starwars.app.mappers.PresentationMapper
import com.example.starwars.app.models.*
import com.example.starwars.domain.models.People
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AppTests {
    val filmPres : FilmPresentation = FilmPresentation(listOf("characters"), "director", 1, "statement",
        listOf("planets"), "producer", "date", listOf("species"), listOf("starships"), "title", listOf("vehicles"))
    val peoplePres : PeoplePresentation = PeoplePresentation("birth year", "eye color", listOf("films"), "gender",
        "hair color", "height", "home world", "mass", "name", "skin color", null, listOf("starships"), listOf("vehicles"))
    val planetPres : PlanetPresentation = PlanetPresentation("climate", "diameter", listOf("films"), "gracity", "name",
        "orbital period", "population", listOf("people"), "rotation period", "surface water", "terrain")
    val speciePres : SpeciePresentation = SpeciePresentation("height", "average lifespan", "classification",
        "designation", "eye color", listOf(), "hair color", "home world", "language", "name", listOf("people"), "skin color")
    val starshipPres : StarshipPresentation = StarshipPresentation(1, 1, "consumable", 1, "crew", listOf("films"),
    2.0, 1, "manufacturer", 1, "model", "name", 1, listOf("pilots"), "starship")

    @Before
    fun setup() {

    }

    @Test
    fun peoplePresentation_to_people_domain_mapping_test() {
        val peopleDomain = PresentationMapper.peopleDomainMapper(peoplePres)

        Assert.assertEquals(People::class.java, peopleDomain::class.java)
    }

    @Test
    fun check_people_mapper_conversion_data() {
        val peopleDomain = PresentationMapper.peopleDomainMapper(peoplePres)

        Assert.assertEquals(peoplePres.birthYear, peopleDomain.birthYear)
        Assert.assertEquals(peoplePres.eyeColor, peopleDomain.eyeColor)
        Assert.assertEquals(peoplePres.films, peopleDomain.films)
        Assert.assertEquals(peoplePres.gender, peopleDomain.gender)
        Assert.assertEquals(peoplePres.mass, peopleDomain.mass)
        Assert.assertEquals(peoplePres.height, peopleDomain.height)
        Assert.assertEquals(peoplePres.hairColor, peopleDomain.hairColor)
        Assert.assertEquals(peoplePres.homeWorld, peopleDomain.homeWorld)
        Assert.assertEquals(peoplePres.name, peopleDomain.name)
        Assert.assertEquals(peoplePres.vehicles, peopleDomain.vehicles)
        Assert.assertEquals(peoplePres.starships, peopleDomain.starships)
        Assert.assertEquals(peoplePres.species, peopleDomain.species)
        Assert.assertEquals(peoplePres.skinColor, peopleDomain.skinColor)
    }


}