package com.ex.skydictionary.screens.wordcard.data.entities.response

import com.ex.skydictionary.screens.search.data.entities.TranslationResponse
import com.google.gson.annotations.SerializedName

class MeaningsWithSimilarTranslationResponse(
    @SerializedName("frequencyPercent")
    var frequencyPercent: Float? = null,
    @SerializedName("partOfSpeechAbbreviation")
    var partOfSpeechAbbreviation: String? = null,
    @SerializedName("translation")
    var translation: TranslationResponse? = null
)
