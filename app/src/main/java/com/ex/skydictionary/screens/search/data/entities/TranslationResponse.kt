package com.ex.skydictionary.screens.search.data.entities

import com.google.gson.annotations.SerializedName

class TranslationResponse(
    @SerializedName("text")
    var text: String? = null,
    @SerializedName("note")
    var note: String? = null
)
