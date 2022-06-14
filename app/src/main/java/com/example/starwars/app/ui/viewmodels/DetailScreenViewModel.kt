package com.example.starwars.app.ui.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.starwars.app.mappers.PresentationMapper
import com.example.starwars.app.models.FilmPresentation
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.models.PlanetPresentation
import com.example.starwars.app.models.SpeciePresentation
import com.example.starwars.app.utils.Resource
import com.example.starwars.app.utils.Status
import com.example.starwars.data.remote.repository.FilmRepositoryImpl
import com.example.starwars.data.remote.repository.PlanetRepositoryImp
import com.example.starwars.data.remote.repository.SpecieRepositoryImp
import com.example.starwars.domain.models.Film
import com.example.starwars.domain.models.Planet
import com.example.starwars.domain.models.Specie
import com.example.starwars.domain.usecases.FetchSpecificFilmUseCase
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

    private val mutableFilmDataList = MutableLiveData<Resource<FilmPresentation>>(Resource.loading(null))
    val filmData : LiveData<Resource<FilmPresentation>> get() = mutableFilmDataList

    val characterData : MutableLiveData<PeoplePresentation?> = MutableLiveData()

    private val TAG : String = "Detail-ViewModel"

    init {
        characterData.observeForever { peoplePresentation ->
            if(peoplePresentation != null ) {
                getPlanetData(peoplePresentation.homeWorld)
                getSpecieData(peoplePresentation.species ?: listOf())
                for(filmUrl in peoplePresentation.films) {
                    getFilmData(filmUrl)
                }
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
                .enqueue(object : Callback<Specie> {
                    override fun onResponse(call: Call<Specie>, response: Response<Specie>) {
                        if(response.isSuccessful) {
                            val _specie = response.body()
                            mutableSpecieData.value =
                                Resource.success(_specie?.let { PresentationMapper.speciePresentationMapper(it) })
                        } else {
                            Log.d(TAG, "onResponse: MESSAGE : ${response.message()} DATA: ${response.errorBody()}")
                            mutableSpecieData.value =
                                Resource.error("Error: Minor issue occurred when fetch specie data", null)
                        }
                    }

                    override fun onFailure(call: Call<Specie>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.message}")
                        mutableSpecieData.value = Resource.error("Error: Specie data fetching failed", null)
                    }
                })

        }
    }

    private fun getFilmData(filmUrl: String) = viewModelScope.launch {
        val repository = FilmRepositoryImpl()

        FetchSpecificFilmUseCase(repository).execute(filmUrl).enqueue(object : Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if(response.isSuccessful) {
                    val _film = response.body()
                    _film?.let {
                        mutableFilmDataList.value =
                            Resource.success(PresentationMapper.filmPresentationMapper(it))
                    }
                } else {
                    Log.d(TAG, "onResponse: MESSAGE : ${response.message()} DATA: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                mutableSpecieData.value = Resource.error("Error: Film data fetching failed", null)
            }
        })

    }


}