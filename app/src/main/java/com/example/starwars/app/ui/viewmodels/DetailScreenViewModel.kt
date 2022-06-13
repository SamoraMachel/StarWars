package com.example.starwars.app.ui.viewmodels

import androidx.lifecycle.*
import com.example.starwars.app.mappers.PresentationMapper
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.models.PlanetPresentation
import com.example.starwars.app.models.SpeciePresentation
import com.example.starwars.app.utils.Resource
import com.example.starwars.data.remote.repository.PlanetRepositoryImp
import com.example.starwars.data.remote.repository.SpecieRepositoryImp
import com.example.starwars.domain.usecases.FetchSpecificPlanetUseCase
import com.example.starwars.domain.usecases.FetchSpecificSpecieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DetailScreenViewModel : ViewModel() {
    private val mutablePlanetData = MutableLiveData<Resource<PlanetPresentation>>(Resource.loading(null))
    val planetData : LiveData<Resource<PlanetPresentation>> get() = mutablePlanetData

    private val mutableSpecieData = MutableLiveData<Resource<SpeciePresentation>>(Resource.loading(null))
    val specieData : LiveData<Resource<SpeciePresentation>> get() = mutableSpecieData

    val characterData : MutableLiveData<PeoplePresentation?> = MutableLiveData()


    init {
        characterData.observeForever { peoplePresentation ->
            if(peoplePresentation != null ) {
                getPlanetData(peoplePresentation.homeWorld)
                getSpecieData(peoplePresentation.species ?: listOf())
            }
        }
    }

    private fun getPlanetData(homeWorld : String) = viewModelScope.launch {
        mutablePlanetData.value = Resource.loading(null)
        val repository = PlanetRepositoryImp()

        FetchSpecificPlanetUseCase(repository).execute(homeWorld).map{
            PresentationMapper.planetPresentationMapper(it)
        }.collect {
            mutablePlanetData.value = Resource.success(it)
        }
    }

    private fun getSpecieData(specie : List<String?>) = viewModelScope.launch {
        mutableSpecieData.value = Resource.loading(null)
        val repository = SpecieRepositoryImp()

        if (specie.size > 0) {
            FetchSpecificSpecieUseCase(repository).execute(specie[0]!!).map {
                PresentationMapper.speciePresentationMapper(it)
            }.collect {
                mutableSpecieData.value = Resource.success(it)
            }
        }
    }


}