package com.ex.skydictionary.screens.search.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.ViewHolderDelegate
import com.ex.skydictionary.internal.extensions.capsFistChar
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO

class DictionaryChildViewHolderDelegate(
    private val onBodyItemClick: (MeaningDTO) -> Unit
) : ViewHolderDelegate<MeaningDTO, DictionaryChildViewHolder>() {
    override fun createViewHolder(parent: ViewGroup): DictionaryChildViewHolder {
        return DictionaryChildViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.dictionary_child_body, parent, false),
            onBodyItemClick
        )
    }

    override fun bind(viewHolder: DictionaryChildViewHolder, data: MeaningDTO) {
        viewHolder.bind(data)
    }
}

class DictionaryChildViewHolder(
    view: View,
    private val onClick: (MeaningDTO) -> Unit
) : BaseViewHolder<MeaningDTO>(view) {

    private val text: TextView by lazy { itemView.findViewById<TextView>(R.id.translation) }
    private val transcription: TextView by lazy { itemView.findViewById<TextView>(R.id.transcription) }

    override fun bind(data: MeaningDTO) {
        text.text = data.translation.text.capsFistChar()
        if (!data.transcription.isNullOrEmpty()) {
            transcription.text = "[${data.transcription}]"
        }
        itemView.setOnClickListener {
            onClick(data)
        }
    }

}