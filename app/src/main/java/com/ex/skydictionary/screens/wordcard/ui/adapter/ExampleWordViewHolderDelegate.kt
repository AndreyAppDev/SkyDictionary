package com.ex.skydictionary.screens.wordcard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.ViewHolderDelegate
import com.ex.skydictionary.internal.extensions.capsFistChar
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningExampleDTO

class ExampleWordViewHolderDelegate :
    ViewHolderDelegate<WordMeaningExampleDTO, ExampleWordViewHolder>() {

    override fun createViewHolder(parent: ViewGroup): ExampleWordViewHolder {
        return ExampleWordViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.example_word_item, parent, false)
        )
    }

    override fun bind(viewHolder: ExampleWordViewHolder, data: WordMeaningExampleDTO) {
        viewHolder.bind(data)
    }

}

class ExampleWordViewHolder(view: View) : BaseViewHolder<WordMeaningExampleDTO>(view) {

    private val exampleText: TextView by lazy { itemView.findViewById<TextView>(R.id.example) }


    override fun bind(data: WordMeaningExampleDTO) {
        exampleText.text = data.text.capsFistChar()
    }
}