package com.example.starwars.data.remote.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.starwars.data.remote.api.PeopleApi
import com.example.starwars.data.remote.api.StarshipApi
import com.example.starwars.data.remote.mappers.NetworkMapper
import com.example.starwars.data.remote.models.PeopleNetwork
import com.example.starwars.data.remote.models.StarshipNetwork
import com.example.starwars.data.remote.responses.BaseResponse
import com.example.starwars.domain.models.People
import retrofit2.HttpException
import java.io.IOException

enum class ApiClass {
    PEOPLE_API,
    STARSHIP_API
}

class BasePagingSource<T : Any>(private val apiClass: ApiClass, private val apiService : Any) : PagingSource<Int, T>()  {
    private suspend fun dataApiResponse(page : Int) : BaseResponse<*> = when(apiClass) {
        ApiClass.PEOPLE_API -> {
            val api = apiService as PeopleApi
            api.fetchPeople(page)
        }
        ApiClass.STARSHIP_API -> {
            val api  = apiService as StarshipApi
            api.fetchStarships(page)
        }
    }

    private fun networkDataMapper(networkData : Any?) = when(apiClass) {
        ApiClass.PEOPLE_API -> NetworkMapper.peopleNetworkMapper(networkData as PeopleNetwork)
        ApiClass.STARSHIP_API -> NetworkMapper.starshipNetworkMapper(networkData as StarshipNetwork)
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val position = params.key ?: 1

        return try {
            val response = dataApiResponse(position)
            Log.d("PagingSource", "load: Data Loaded ${response.results}")
            val dataList : List<T> = response.results.map { networkData ->
                networkDataMapper(networkData) as T
            }

            val nextKey = if(dataList.isEmpty()) {
                null
            } else {
                position + (params.loadSize / 10)
            }

            LoadResult.Page(
                data = dataList,
                prevKey = if (position == 1) null else (position - 1),
                nextKey = nextKey
            )
        } catch (e : IOException) {
            LoadResult.Error(e)
        } catch (e : HttpException) {
            LoadResult.Error(e)
        }
    }
}