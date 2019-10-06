package com.ex.skydictionary.screens.wordcard.data.entities.response

import com.google.gson.annotations.SerializedName

class DefinitionResponse(
    @SerializedName("text")
    var text: String? = null
)
