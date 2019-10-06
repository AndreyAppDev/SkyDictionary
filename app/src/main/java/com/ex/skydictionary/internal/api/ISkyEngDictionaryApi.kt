package com.ex.skydictionary.internal.api

import com.ex.skydictionary.screens.search.data.entities.SearchInDirectoryResponse
import com.ex.skydictionary.screens.wordcard.data.entities.response.WordMeaningDetailResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ISkyEngDictionaryApi {
    companion object {
        private const val BASE_PATH = "api/public/v1"
    }

    @GET("$BASE_PATH/words/search")
    fun search(@Query("search") query: String): Single<List<SearchInDirectoryResponse>>

    @GET("$BASE_PATH/meanings")
    fun loadWordMeaningsDetailInfo(@Query("ids") id: Int, @Query("width") width: Int = 640): Single<List<WordMeaningDetailResponse>>

}
