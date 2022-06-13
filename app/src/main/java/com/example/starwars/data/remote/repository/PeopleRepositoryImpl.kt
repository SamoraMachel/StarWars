package com.example.starwars.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.starwars.data.remote.api.PeopleApi
import com.example.starwars.data.remote.api.buildRetrofitService
import com.example.starwars.data.remote.models.PeopleNetwork
import com.example.starwars.data.remote.pagingsource.ApiClass
import com.example.starwars.data.remote.pagingsource.BasePagingSource
import com.example.starwars.domain.models.People
import com.example.starwars.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow

class PeopleRepositoryImpl() : PeopleRepository {

    override fun fetchPeople(): Flow<PagingData<People>> { val peopleApiService : PeopleApi = buildRetrofitService(PeopleApi::class.java)
        val peoplePagingData : BasePagingSource<People> = BasePagingSource(ApiClass.PEOPLE_API, peopleApiService)

        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {peoplePagingData}
        ).flow
    }

    override fun searchPeople(search: String): Flow<PagingData<People>> {
        val peopleApiService : PeopleApi = buildRetrofitService(PeopleApi::class.java)
        val peoplePagingData: BasePagingSource<People> = BasePagingSource(ApiClass.PEOPLE_API, peopleApiService, search)

        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {peoplePagingData}
        ).flow
    }
}