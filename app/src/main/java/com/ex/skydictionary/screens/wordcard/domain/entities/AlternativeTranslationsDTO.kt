package com.ex.skydictionary.screens.wordcard.domain.entities

import com.ex.skydictionary.internal.adapter.ListItemView
import com.ex.skydictionary.screens.search.domain.entities.response.TranslationDTO

data class AlternativeTranslationsDTO(
    val text: String,
    val translation: TranslationDTO
) : ListItemView
