package com.ex.skydictionary.screens.wordcard.ui.adapter

import com.bumptech.glide.RequestManager
import com.ex.skydictionary.internal.adapter.MultipleViewTypeAdapter
import com.ex.skydictionary.internal.adapter.SectionHeaderItemView
import com.ex.skydictionary.screens.wordcard.domain.entities.AlternativeTranslationsDTO
import com.ex.skydictionary.screens.wordcard.domain.entities.MeaningsWithSimilarTranslationDTO
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningExampleDTO
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningImageDTO

class WordMeaningsDetailAdapter(
    requestManager: RequestManager
) : MultipleViewTypeAdapter() {

    init {
        addDelegate(SectionHeaderItemView::class.java, SectionHeaderViewHolderDelegate())
        addDelegate(WordMeaningExampleDTO::class.java, ExampleWordViewHolderDelegate())
        addDelegate(
            MeaningsWithSimilarTranslationDTO::class.java,
            MeaningWithSimilarTranslationViewHolderDelegate()
        )
        addDelegate(WordMeaningImageDTO::class.java, WordImageViewHolderDelegate(requestManager))
        addDelegate(AlternativeTranslationsDTO::class.java, AlternativeWordViewHolderDelegate())
    }

}
