package com.ex.skydictionary.screens.wordcard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.ViewHolderDelegate
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningImageDTO

class WordImageViewHolderDelegate(
    private val requestManager: RequestManager
) : ViewHolderDelegate<WordMeaningImageDTO, WordImageViewHolder>() {

    override fun createViewHolder(parent: ViewGroup): WordImageViewHolder {
        return WordImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.word_image_item, parent, false),
            requestManager
        )
    }

    override fun bind(viewHolder: WordImageViewHolder, data: WordMeaningImageDTO) {
        viewHolder.bind(data)
    }

}

class WordImageViewHolder(view: View, private val requestManager: RequestManager) :
    BaseViewHolder<WordMeaningImageDTO>(view) {

    private val image: ImageView by lazy { itemView.findViewById<ImageView>(R.id.word_image) }

    override fun bind(data: WordMeaningImageDTO) {
        requestManager.load(data.imageUrl).into(image)
    }
}
