package com.ex.skydictionary.screens.search.domain.entities.response

import com.ex.skydictionary.internal.adapter.ListItemView

data class MeaningDTO(
    val id: Int,
    val translation: TranslationDTO,
    val transcription: String?,
    val partOfSpeech: PartOfSpeech
) : ListItemView
