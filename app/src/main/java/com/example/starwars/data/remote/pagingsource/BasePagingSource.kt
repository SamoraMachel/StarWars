package com.example.starwars.data.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.starwars.data.remote.api.PeopleApi
import com.example.starwars.data.remote.api.StarshipApi
import com.example.starwars.data.remote.mappers.NetworkMapper
import com.example.starwars.data.remote.models.PeopleNetwork
import com.example.starwars.data.remote.models.StarshipNetwork
import com.example.starwars.data.remote.responses.BaseResponse
import retrofit2.HttpException
import java.io.IOException
import kotlin.reflect.typeOf

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

    private fun networkDataMapper(networkData : Any) = when(apiClass) {
        ApiClass.PEOPLE_API -> NetworkMapper.PeopleNetworkMapper(networkData as PeopleNetwork)
        ApiClass.STARSHIP_API -> NetworkMapper.StarshipNeworkMapper(networkData as StarshipNetwork)
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val position = params.key ?: 1

        return try {
            val response = dataApiResponse(position)
            val dataList : List<T> = response.result.map { networkData ->
                networkData?.let {
                    networkDataMapper(it)
                }
                networkData as T
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