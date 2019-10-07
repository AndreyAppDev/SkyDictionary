package com.ex.skydictionary.screens.search.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.ViewHolderDelegate
import com.ex.skydictionary.internal.extensions.capsFistChar
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech

class DictionaryChildHeaderViewHolderDelegate :
    ViewHolderDelegate<PartOfSpeech, DictionaryChildHeaderViewHolder>() {

    override fun createViewHolder(parent: ViewGroup): DictionaryChildHeaderViewHolder {
        return DictionaryChildHeaderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dictionary_child_header,
                parent,
                false
            )
        )
    }

    override fun bind(viewHolder: DictionaryChildHeaderViewHolder, data: PartOfSpeech) {
        viewHolder.bind(data)
    }

}

class DictionaryChildHeaderViewHolder(view: View) : BaseViewHolder<PartOfSpeech>(view) {

    private val header: TextView by lazy { itemView.findViewById<TextView>(R.id.header) }

    override fun bind(data: PartOfSpeech) {
        header.text = data.text.capsFistChar()
    }

}