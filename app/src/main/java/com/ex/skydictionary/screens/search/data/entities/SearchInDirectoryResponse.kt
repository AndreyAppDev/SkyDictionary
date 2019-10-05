package com.ex.skydictionary.screens.search.data.entities

import com.google.gson.annotations.SerializedName

class SearchInDirectoryResponse {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("meanings")
    var meanings: List<MeaningResponse>? = null

    @SerializedName("text")
    var text: String? = null

}
