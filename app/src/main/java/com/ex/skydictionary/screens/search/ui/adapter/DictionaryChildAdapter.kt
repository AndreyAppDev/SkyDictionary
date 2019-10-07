package com.ex.skydictionary.screens.search.ui.adapter

import com.ex.skydictionary.internal.adapter.ListItemView
import com.ex.skydictionary.internal.adapter.MultipleViewTypeAdapter
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech

class DictionaryChildAdapter(
    onBodyItemClick: (MeaningDTO) -> Unit
) : MultipleViewTypeAdapter() {

    init {
        addDelegate(PartOfSpeech::class.java, DictionaryChildHeaderViewHolderDelegate())
        addDelegate(MeaningDTO::class.java, DictionaryChildViewHolderDelegate(onBodyItemClick))
    }

    fun updateAll(data: List<ListItemView>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

}
