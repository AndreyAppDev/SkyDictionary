package com.ex.skydictionary.screens.search.domain.entities.response

import android.os.Parcelable
import com.ex.skydictionary.internal.adapter.ListItemView
import kotlinx.android.parcel.Parcelize

@Parcelize
class MeaningDTO(
    val id: Int,
    val translation: TranslationDTO,
    val transcription: String?,
    val partOfSpeech: PartOfSpeech
) : ListItemView, Parcelable
