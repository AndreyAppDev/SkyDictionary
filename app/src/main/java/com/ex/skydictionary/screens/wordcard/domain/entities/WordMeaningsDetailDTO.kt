package com.ex.skydictionary.screens.wordcard.domain.entities

import com.ex.skydictionary.internal.adapter.ListItemView
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech
import com.ex.skydictionary.screens.search.domain.entities.response.TranslationDTO

data class WordMeaningsDetailDTO(
    val id: Int?,
    val partOfSpeech: PartOfSpeech?,
    val text: String?,
    val translation: TranslationDTO?,
    val transcription: String?,
    val images: WordMeaningImageDTO?,
    val definitions: WordDefinitionDTO,
    val examples: List<WordMeaningExampleDTO>?,
    val meaningsWithSimilarTranslation: List<MeaningsWithSimilarTranslationDTO>?,
    val alternativeTranslations: List<AlternativeTranslationsDTO>?,
    val wordMeaningDetails: List<ListItemView>
)
