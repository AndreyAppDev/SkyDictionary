package com.ex.skydictionary.screens.wordcard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.ViewHolderDelegate
import com.ex.skydictionary.screens.wordcard.domain.entities.AlternativeTranslationsDTO

class AlternativeWordViewHolderDelegate :
    ViewHolderDelegate<AlternativeTranslationsDTO, AlternativeWordViewHolder>() {

    override fun createViewHolder(parent: ViewGroup): AlternativeWordViewHolder {
        return AlternativeWordViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.word_alternative_item,
                parent,
                false
            )
        )
    }

    override fun bind(viewHolder: AlternativeWordViewHolder, data: AlternativeTranslationsDTO) {
        viewHolder.bind(data)
    }
}

class AlternativeWordViewHolder(view: View) : BaseViewHolder<AlternativeTranslationsDTO>(view) {

    private val word: TextView by lazy { itemView.findViewById<TextView>(R.id.word) }
    private val wordTranslation: TextView by lazy { itemView.findViewById<TextView>(R.id.word_translation) }

    override fun bind(data: AlternativeTranslationsDTO) {
        word.text = data.text
        wordTranslation.text = data.translation.text
    }

}
