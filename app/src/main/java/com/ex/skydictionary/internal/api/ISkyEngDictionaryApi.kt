package com.ex.skydictionary.internal.api

import com.ex.skydictionary.screens.search.data.entities.SearchInDirectoryResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ISkyEngDictionaryApi {
    companion object {
        private const val BASE_PATH = "api/public/v1"
    }

    @GET("$BASE_PATH/words/search")
    fun search(@Query("search") query: String): Single<List<SearchInDirectoryResponse>>

}
