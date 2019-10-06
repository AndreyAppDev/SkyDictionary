package com.ex.skydictionary.screens.wordcard.data.entities.response

import com.ex.skydictionary.screens.search.data.entities.TranslationResponse
import com.google.gson.annotations.SerializedName

class WordMeaningDetailResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("partOfSpeechCode")
    var partOfSpeechCode: String? = null,
    @SerializedName("text")
    var text: String? = null,
    @SerializedName("transcription")
    var transcription: String? = null,
    @SerializedName("translation")
    var translation: TranslationResponse? = null,
    @SerializedName("images")
    var images: List<ImageResponse>? = null,
    @SerializedName("definition")
    var definition: DefinitionResponse? = null,
    @SerializedName("examples")
    var examples: List<WordMeaningExampleResponse>? = null,
    @SerializedName("meaningsWithSimilarTranslation")
    var meaningsWithSimilarTranslation: List<MeaningsWithSimilarTranslationResponse>? = null,
    @SerializedName("alternativeTranslations")
    var alternativeTranslationsResponse: List<AlternativeTranslationsResponse>? = null
)
