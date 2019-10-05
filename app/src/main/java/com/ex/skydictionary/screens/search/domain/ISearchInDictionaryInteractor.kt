package com.ex.skydictionary.screens.search.domain

import com.ex.skydictionary.screens.search.domain.entities.request.SearchInDirectoryRequestDTO
import com.ex.skydictionary.screens.search.domain.entities.response.SearchInDirectoryDTO
import io.reactivex.Single

interface ISearchInDictionaryInteractor {
    fun search(request: SearchInDirectoryRequestDTO): Single<List<SearchInDirectoryDTO>>
}
