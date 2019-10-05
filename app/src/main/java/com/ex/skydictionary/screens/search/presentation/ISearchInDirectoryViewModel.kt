package com.ex.skydictionary.screens.search.presentation

import androidx.lifecycle.LiveData
import com.ex.skydictionary.screens.search.domain.entities.response.SearchInDirectoryDTO

interface ISearchInDirectoryViewModel {
    val dataForDictionary: LiveData<List<SearchInDirectoryDTO>>

    fun search(query: String)
}
