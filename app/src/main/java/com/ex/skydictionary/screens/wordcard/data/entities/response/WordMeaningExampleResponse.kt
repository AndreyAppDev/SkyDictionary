package com.ex.skydictionary.screens.wordcard.data.entities.response

import com.google.gson.annotations.SerializedName

class WordMeaningExampleResponse(
    @SerializedName("text")
    var text: String? = null
)