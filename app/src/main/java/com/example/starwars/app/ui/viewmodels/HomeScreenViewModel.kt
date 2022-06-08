package com.example.starwars.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.starwars.app.mappers.PresentationMapper
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.utils.Resource
import com.example.starwars.data.remote.repository.PeopleRepositoryImpl
import com.example.starwars.domain.usecases.FetchPeopleUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel(){

    // Data variables
    private val mutableCharacterDataList = MutableStateFlow<Resource<PagingData<PeoplePresentation>>>(Resource.loading(null))
    val characterDataList : StateFlow<Resource<PagingData<PeoplePresentation>>>
        get() = mutableCharacterDataList.asStateFlow()

    init {
        fetchPeopleData()
    }


    private fun fetchPeopleData() = viewModelScope.launch {
        val peopleRepository = PeopleRepositoryImpl()

        mutableCharacterDataList.emit(Resource.loading(null))
        FetchPeopleUseCase(peopleRepository).execute().map { pagingData ->
            pagingData.map { people ->
                PresentationMapper.peoplePresentationMapper(people)
            }
        }.cachedIn(this).collect {
            mutableCharacterDataList.emit(Resource.success(it))
        }
    }

}