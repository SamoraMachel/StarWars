package com.example.starwars.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.starwars.data.remote.api.StarshipApi
import com.example.starwars.data.remote.api.buildRetrofitService
import com.example.starwars.data.remote.pagingsource.ApiClass
import com.example.starwars.data.remote.pagingsource.BasePagingSource
import com.example.starwars.domain.models.Starship
import com.example.starwars.domain.repository.StarshipRepository
import kotlinx.coroutines.flow.Flow

class StarshipRepositoryImpl(private val starshipRepository: StarshipRepository) : StarshipRepository {

    override fun fetchStarships(): Flow<PagingData<Starship>> {
        val starshipApiService : StarshipApi = buildRetrofitService(StarshipApi::class.java)
        val starshipPagingData : BasePagingSource<Starship> = BasePagingSource(ApiClass.STARSHIP_API, starshipApiService)

        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {starshipPagingData}
        ).flow
    }
}