package com.ex.skydictionary.screens.search.data.entities

import com.google.gson.annotations.SerializedName

class MeaningResponse {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("translation")
    var translation: TranslationResponse? = null

    @SerializedName("transcription")
    var transcription: String? = null

}
