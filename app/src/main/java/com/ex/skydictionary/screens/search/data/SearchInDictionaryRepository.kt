package com.ex.skydictionary.screens.search.data

import com.ex.skydictionary.internal.api.ISkyEngDictionaryApi
import com.ex.skydictionary.screens.search.data.entities.SearchInDirectoryResponse
import com.ex.skydictionary.screens.search.domain.entities.request.SearchInDirectoryRequestDTO
import io.reactivex.Single
import javax.inject.Inject

class SearchInDictionaryRepository @Inject constructor(
    private val api: ISkyEngDictionaryApi
) : ISearchInDictionaryRepository {

    override fun search(request: SearchInDirectoryRequestDTO): Single<List<SearchInDirectoryResponse>> {
        return api.search(request.query)
    }

}
