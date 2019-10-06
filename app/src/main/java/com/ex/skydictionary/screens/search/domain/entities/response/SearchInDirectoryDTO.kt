package com.ex.skydictionary.screens.search.domain.entities.response

import com.ex.skydictionary.internal.adapter.ListItemView

data class SearchInDirectoryDTO(
    val id: Int,
    val text: String,
    val meanings: List<MeaningDTO>,
    val gropedMeanings: List<ListItemView> =
        meanings.groupBy { it.partOfSpeech }
            .flatMap { item: Map.Entry<PartOfSpeech, List<MeaningDTO>> ->
                val list = mutableListOf<ListItemView>()
                list.add(item.key)
                list += item.value
                list
            }

)
