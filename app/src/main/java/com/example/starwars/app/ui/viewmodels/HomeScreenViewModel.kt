package com.example.starwars.app.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.starwars.app.mappers.PresentationMapper
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.utils.Resource
import com.example.starwars.data.remote.repository.PeopleRepositoryImpl
import com.example.starwars.domain.repository.PeopleRepository
import com.example.starwars.domain.usecases.FetchPeopleUseCase
import com.example.starwars.domain.usecases.SearchPeopleUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel(){

    // Data variables
    private val mutableCharacterDataList = MutableStateFlow<Resource<PagingData<PeoplePresentation>>>(Resource.loading(null))
    val characterDataList : StateFlow<Resource<PagingData<PeoplePresentation>>>
        get() = mutableCharacterDataList.asStateFlow()

    val mutableSearchData = MutableLiveData<String>("")


    init {
        fetchPeopleData()

        mutableSearchData.observeForever { search ->
            if(search != null) {
                searchPeopleData(search)
            }
        }
    }


    private fun fetchPeopleData() = viewModelScope.launch {
        val peopleRepository = PeopleRepositoryImpl()

        mutableCharacterDataList.emit(Resource.loading(null))
        FetchPeopleUseCase(peopleRepository).execute().map { pagingData ->
            pagingData.map { peopleNetwork ->
                PresentationMapper.peoplePresentationMapper(peopleNetwork)
            }
        }.cachedIn(this).collect {
            mutableCharacterDataList.emit(Resource.success(it))
        }
    }

    private fun searchPeopleData(search_data : String) = viewModelScope.launch {
        val peopleRepository = PeopleRepositoryImpl()

        mutableCharacterDataList.emit(Resource.loading(null))
        SearchPeopleUseCase(peopleRepository).execute(search_data).map{ pagingData ->
            pagingData.map { peopleNetwork ->
                PresentationMapper.peoplePresentationMapper(peopleNetwork)
            }
        }.cachedIn(this).collect {
            mutableCharacterDataList.emit(Resource.success(it))
        }
    }
}