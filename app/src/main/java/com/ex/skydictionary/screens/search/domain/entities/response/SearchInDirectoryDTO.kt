package com.ex.skydictionary.screens.search.domain.entities.response

data class SearchInDirectoryDTO(
    val id: Int,
    val text: String,
    val meanings: List<MeaningDTO>
)
