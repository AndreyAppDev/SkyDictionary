package com.ex.skydictionary.screens.search.domain.entities.response

import com.ex.skydictionary.internal.adapter.ListItemView

enum class PartOfSpeech(val text: String) : ListItemView {
    NOUN("сущ."),
    VERB("глаг."),
    ADJECTIVE("прил."),
    ADVERB("нар."),
    PREPOSITION("предл."),
    PRONOUN("мест."),
    CARDINAL_NUMBER("числ."),
    CONJUNCTION("союз"),
    INTERJECTION("межд."),
    ARTICLE("артикль"),
    ABBREVIATION("аббревиатура"),
    PARTICLE("частица"),
    ORDINAL_NUMBER("порядковый"),
    MODAL_VERB("модальный глагол"),
    PHRASE("фраза"),
    IDIOM("идиома"),
    UNEXPECTED("")
}
