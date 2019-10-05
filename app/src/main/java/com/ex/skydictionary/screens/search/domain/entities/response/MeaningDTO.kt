package com.ex.skydictionary.screens.search.domain.entities.response

data class MeaningDTO(
    val id: Int,
    val translation: TranslationDTO,
    val transcription: String?
)
