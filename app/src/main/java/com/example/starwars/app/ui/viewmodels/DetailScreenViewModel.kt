package com.example.starwars.app.ui.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.starwars.app.mappers.PresentationMapper
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.models.PlanetPresentation
import com.example.starwars.app.models.SpeciePresentation
import com.example.starwars.app.utils.Resource
import com.example.starwars.data.remote.repository.PlanetRepositoryImp
import com.example.starwars.data.remote.repository.SpecieRepositoryImp
import com.example.starwars.domain.models.Planet
import com.example.starwars.domain.usecases.FetchSpecificPlanetUseCase
import com.example.starwars.domain.usecases.FetchSpecificSpecieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailScreenViewModel : ViewModel() {
    private val mutablePlanetData = MutableLiveData<Resource<PlanetPresentation>>(Resource.loading(null))
    val planetData : LiveData<Resource<PlanetPresentation>> get() = mutablePlanetData

    private val mutableSpecieData = MutableLiveData<Resource<SpeciePresentation>>(Resource.loading(null))
    val specieData : LiveData<Resource<SpeciePresentation>> get() = mutableSpecieData

    val characterData : MutableLiveData<PeoplePresentation?> = MutableLiveData()

    private val TAG : String = "Detail-ViewModel"

    init {
        characterData.observeForever { peoplePresentation ->
            if(peoplePresentation != null ) {
                getPlanetData(peoplePresentation.homeWorld)
//                getSpecieData(peoplePresentation.species ?: listOf())
            }
        }
    }

    private fun getPlanetData(homeWorld : String) = viewModelScope.launch {
        mutablePlanetData.value = Resource.loading(null)
        val repository = PlanetRepositoryImp()

        FetchSpecificPlanetUseCase(repository).execute(homeWorld)
            .enqueue(object : Callback<Planet> {
                override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                    if(response.isSuccessful) {
                        val _planet = response.body()
                        mutablePlanetData.value =
                            Resource.success(_planet?.let { PresentationMapper.planetPresentationMapper(it) })
                    } else {
                        Log.d(TAG, "onResponse: MESSAGE : ${response.message()} DATA: ${response.errorBody()}")
                        mutablePlanetData.value =
                            Resource.error("Error: Minor issue occurred when fetch planet data", null)
                    }
                }

                override fun onFailure(call: Call<Planet>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                    mutablePlanetData.value = Resource.error("Error: Planet data fetching failed", null)
                }
            })
    }

    private fun getSpecieData(specie : List<String?>) = viewModelScope.launch {
        mutableSpecieData.value = Resource.loading(null)
        val repository = SpecieRepositoryImp()

        if (specie.size > 0) {
            FetchSpecificSpecieUseCase(repository).execute(specie[0]!!)
                .body()?.let { _specie ->
                    PresentationMapper.speciePresentationMapper(_specie).let { _speciePresentation ->
                        mutableSpecieData.value = Resource.success(_speciePresentation)
                    }
                }
        }
    }


}