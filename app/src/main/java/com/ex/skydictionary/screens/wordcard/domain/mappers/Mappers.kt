package com.ex.skydictionary.screens.wordcard.domain.mappers

import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.ListItemView
import com.ex.skydictionary.internal.adapter.SectionHeaderItemView
import com.ex.skydictionary.internal.app.IResourceProvider
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
    private val alternativeTranslationsMapper: IMapper<AlternativeTranslationsResponse, AlternativeTranslationsDTO>,
    private val resources: IResourceProvider
) : IMapper<WordMeaningDetailResponse, WordMeaningsDetailDTO> {

    override fun map(data: WordMeaningDetailResponse): WordMeaningsDetailDTO {
        val examples = data.examples?.map(wordMeaningExampleMapper::map)
        val meaningsWithSimilarTranslation = data.meaningsWithSimilarTranslation?.map(
            wordMeaningWithSimilarTranslationMapper::map
        )
        val alternativeTranslations = data.alternativeTranslationsResponse?.map(
            alternativeTranslationsMapper::map
        )
        val image = imageMapper.map(data.images?.first())
        return WordMeaningsDetailDTO(
            id = data.id,
            partOfSpeech = partOfSpeechMapper.map(data.partOfSpeechCode),
            text = data.text,
            translation = data.translation?.let { transitionManager.map(it) },
            transcription = data.transcription?.let { "[$it]" },
            images = image,
            definitions = definitionMapper.map(requireNotNull(data.definition)),
            examples = examples,
            meaningsWithSimilarTranslation = meaningsWithSimilarTranslation,
            alternativeTranslations = alternativeTranslations,
            wordMeaningDetails = mutableListOf<ListItemView>().apply {
                combineData(resources.getString(R.string.examples_header), examples, this)
                image?.let {
                    add(SectionHeaderItemView(resources.getString(R.string.image_header)))
                    add(it)
                }
                combineData(
                    resources.getString(R.string.meaningsWithSimilarTranslation_header),
                    meaningsWithSimilarTranslation,
                    this
                )
                combineData(
                    resources.getString(R.string.alternative_header),
                    alternativeTranslations?.take(10),
                    this
                )

            }
        )
    }

    private fun combineData(
        headerText: String,
        newData: List<ListItemView>?,
        container: MutableList<ListItemView>
    ) {
        newData?.let {
            if (it.isNotEmpty()) {
                container.add(SectionHeaderItemView(headerText))
                container.addAll(it)
            }
        }
    }

}

class WordImageMapper @Inject constructor() : IMapper<ImageResponse?, WordMeaningImageDTO?> {
    override fun map(data: ImageResponse?): WordMeaningImageDTO? {
        return if (data?.url != null) WordMeaningImageDTO(clearUrl(data.url)) else null
    }

    private fun clearUrl(url: String?): String? =
        when {
            url?.startsWith("htt") == false -> "https:$url"
            else -> url
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
