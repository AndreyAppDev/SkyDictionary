package com.ex.skydictionary.screens.search.domain

import com.ex.skydictionary.internal.helpers.suppressException
import com.ex.skydictionary.internal.mapper.IMapper
import com.ex.skydictionary.screens.search.data.ISearchInDictionaryRepository
import com.ex.skydictionary.screens.search.data.entities.SearchInDirectoryResponse
import com.ex.skydictionary.screens.search.domain.entities.request.SearchInDirectoryRequestDTO
import com.ex.skydictionary.screens.search.domain.entities.response.SearchInDirectoryDTO
import io.reactivex.Single
import javax.inject.Inject

class SearchInDictionaryInteractor @Inject constructor(
    private val repo: ISearchInDictionaryRepository,
    private val mapper: IMapper<SearchInDirectoryResponse, SearchInDirectoryDTO>
) : ISearchInDictionaryInteractor {

    override fun search(request: SearchInDirectoryRequestDTO): Single<List<SearchInDirectoryDTO>> {
        return repo.search(request)
            .flatMap { items ->
                Single.just(
                    items.mapNotNull {
                        suppressException({
                            mapper.map(it)
                        }, null)
                    }.toList()
                )
            }
    }

}
