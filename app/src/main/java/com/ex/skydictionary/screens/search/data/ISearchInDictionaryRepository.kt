package com.ex.skydictionary.screens.search.data

import com.ex.skydictionary.screens.search.data.entities.SearchInDirectoryResponse
import com.ex.skydictionary.screens.search.domain.entities.request.SearchInDirectoryRequestDTO
import io.reactivex.Single

interface ISearchInDictionaryRepository {
    fun search(request: SearchInDirectoryRequestDTO): Single<List<SearchInDirectoryResponse>>
}
