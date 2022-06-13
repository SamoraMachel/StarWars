package com.example.starwars.app.ui.viewmodels

import androidx.lifecycle.*
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.models.PlanetPresentation
import com.example.starwars.app.utils.Resource
import com.example.starwars.data.remote.repository.SpecieRepositoryImp
import com.example.starwars.domain.usecases.FetchSpecificSpecieUseCas
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
class DetailScreenViewModel : ViewModel() {
    private val mutablePlanetData = MutableLiveData<Resource<PlanetPresentation>>(Resource.loading(null))
    val planetData : LiveData<Resource<PlanetPresentation>> get() = mutablePlanetData

    val characterData : MutableLiveData<PeoplePresentation?> = MutableLiveData()

    init {
        getPlanetData()
    }

    private fun getPlanetData(homeWorld : String) = viewModelScope.launch {
        mutablePlanetData.value = Resource.loading(null)

        val repository = SpecieRepositoryImp()

        FetchSpecificSpecieUseCas(repository).execute(homeWorld).map {

        }


    }


}