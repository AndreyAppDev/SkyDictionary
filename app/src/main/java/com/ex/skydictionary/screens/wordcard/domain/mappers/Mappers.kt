package com.ex.skydictionary.screens.wordcard.domain.mappers

import com.ex.skydictionary.internal.mapper.IMapper
import com.ex.skydictionary.screens.search.data.entities.TranslationResponse
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech
import com.ex.skydictionary.screens.search.domain.entities.response.TranslationDTO
import com.ex.skydictionary.screens.wordcard.data.entities.response.*
import com.ex.skydictionary.screens.wordcard.domain.entities.*
import javax.inject.Inject

class WordMeaningsDetailMapper @Inject constructor(
    private val partOfSpeechMapper: IMapper<String?, PartOfSpeech>,
    private val transitionManager: IMapper<TranslationResponse, TranslationDTO>,
    private val imageMapper: IMapper<ImageResponse?, WordMeaningImageDTO?>,
    private val definitionMapper: IMapper<DefinitionResponse, WordDefinitionDTO>,
    private val wordMeaningExampleMapper: IMapper<WordMeaningExampleResponse, WordMeaningExampleDTO>,
    private val wordMeaningWithSimilarTranslationMapper: IMapper<MeaningsWithSimilarTranslationResponse,
            MeaningsWithSimilarTranslationDTO>,
    private val alternativeTranslationsMapper: IMapper<AlternativeTranslationsResponse, AlternativeTranslationsDTO>
) : IMapper<WordMeaningDetailResponse, WordMeaningsDetailDTO> {

    override fun map(data: WordMeaningDetailResponse): WordMeaningsDetailDTO {
        return WordMeaningsDetailDTO(
            id = data.id,
            partOfSpeech = partOfSpeechMapper.map(data.partOfSpeechCode),
            text = data.text,
            translation = data.translation?.let { transitionManager.map(it) },
            transcription = data.transcription?.let { "[$it]" },
            images = imageMapper.map(data.images?.first()),
            definitions = definitionMapper.map(requireNotNull(data.definition)),
            examples = data.examples?.map(wordMeaningExampleMapper::map),
            meaningsWithSimilarTranslation = data.meaningsWithSimilarTranslation?.map(
                wordMeaningWithSimilarTranslationMapper::map
            ),
            alternativeTranslations = data.alternativeTranslationsResponse?.map(
                alternativeTranslationsMapper::map
            )
        )
    }
}

class WordImageMapper @Inject constructor() : IMapper<ImageResponse?, WordMeaningImageDTO?> {
    override fun map(data: ImageResponse?): WordMeaningImageDTO? {
        return if (data != null) WordMeaningImageDTO(data.url) else null
    }
}

class DefinitionsMapper @Inject constructor() : IMapper<DefinitionResponse, WordDefinitionDTO> {

    override fun map(data: DefinitionResponse): WordDefinitionDTO {
        return WordDefinitionDTO(requireNotNull(data.text))
    }
}

class WordMeaningExampleMapper @Inject constructor() :
    IMapper<WordMeaningExampleResponse, WordMeaningExampleDTO> {

    override fun map(data: WordMeaningExampleResponse): WordMeaningExampleDTO {
        return WordMeaningExampleDTO(requireNotNull(data.text))
    }

}

class MeaningWithSimilarTranslationMapper @Inject constructor(
    private val transitionManager: IMapper<TranslationResponse, TranslationDTO>
) : IMapper<MeaningsWithSimilarTranslationResponse, MeaningsWithSimilarTranslationDTO> {

    override fun map(data: MeaningsWithSimilarTranslationResponse): MeaningsWithSimilarTranslationDTO {
        return MeaningsWithSimilarTranslationDTO(
            frequencyPercent = data.frequencyPercent,
            partOfSpeechAbbreviation = data.partOfSpeechAbbreviation,
            translation = transitionManager.map(requireNotNull(data.translation))
        )
    }

}

class AlternativeTranslationsMapper @Inject constructor(
    private val transitionManager: IMapper<TranslationResponse, TranslationDTO>
) : IMapper<AlternativeTranslationsResponse, AlternativeTranslationsDTO> {

    override fun map(data: AlternativeTranslationsResponse): AlternativeTranslationsDTO {
        return AlternativeTranslationsDTO(
            text = requireNotNull(data.text),
            translation = transitionManager.map(requireNotNull(data.translation))
        )
    }
}
