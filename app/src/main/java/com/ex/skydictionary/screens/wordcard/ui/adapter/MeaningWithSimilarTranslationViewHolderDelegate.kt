package com.ex.skydictionary.screens.wordcard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.ViewHolderDelegate
import com.ex.skydictionary.screens.wordcard.domain.entities.MeaningsWithSimilarTranslationDTO

class MeaningWithSimilarTranslationViewHolderDelegate :
    ViewHolderDelegate<MeaningsWithSimilarTranslationDTO, MeaningWithSimilarTranslationViewHolder>() {

    override fun createViewHolder(parent: ViewGroup): MeaningWithSimilarTranslationViewHolder {
        return MeaningWithSimilarTranslationViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.meaning_with_similar_translation_item, parent, false)
        )
    }

    override fun bind(
        viewHolder: MeaningWithSimilarTranslationViewHolder,
        data: MeaningsWithSimilarTranslationDTO
    ) {
        viewHolder.bind(data)
    }
}

class MeaningWithSimilarTranslationViewHolder(view: View) :
    BaseViewHolder<MeaningsWithSimilarTranslationDTO>(view) {

    private val translationText: TextView by lazy { itemView.findViewById<TextView>(R.id.translation_text) }
    private val partSpeechAbbreviation:
            TextView by lazy { itemView.findViewById<TextView>(R.id.part_speech_abbreviation) }


    override fun bind(data: MeaningsWithSimilarTranslationDTO) {
        translationText.text = data.translation.text
        partSpeechAbbreviation.text = data.partOfSpeechAbbreviation
    }

}