package com.ex.skydictionary.screens.search.domain.entities.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TranslationDTO(
    val text: String,
    val note: String?
) : Parcelable
