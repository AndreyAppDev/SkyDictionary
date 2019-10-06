package com.ex.skydictionary.internal.helpers

import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech.*
import dagger.Module
import dagger.Provides

@Module
class PartOfSpeechCodeMapModule {

    @Provides
    fun providePartOfSpeechCodeMap(): Map<String, PartOfSpeech> =
        mapOf(
            "n" to NOUN,
            "v" to VERB,
            "j" to ADJECTIVE,
            "r" to ADVERB,
            "prp" to PREPOSITION,
            "prn" to PRONOUN,
            "crd" to CARDINAL_NUMBER,
            "cjc" to CONJUNCTION,
            "exc" to INTERJECTION,
            "det" to ARTICLE,
            "abb" to ABBREVIATION,
            "x" to PARTICLE,
            "ord" to ORDINAL_NUMBER,
            "md" to MODAL_VERB,
            "ph" to PHRASE,
            "phi" to IDIOM
        )
}
