package com.ex.skydictionary.screens.search.domain.mapper

import com.ex.skydictionary.internal.mapper.IMapper
import com.ex.skydictionary.screens.search.data.entities.MeaningResponse
import com.ex.skydictionary.screens.search.data.entities.SearchInDirectoryResponse
import com.ex.skydictionary.screens.search.data.entities.TranslationResponse
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech
import com.ex.skydictionary.screens.search.domain.entities.response.SearchInDirectoryDTO
import com.ex.skydictionary.screens.search.domain.entities.response.TranslationDTO
import java.util.*
import javax.inject.Inject

class SearchInDirectoryModelMapper @Inject constructor(
    private val meaningModelMapper: IMapper<MeaningResponse, MeaningDTO>
) : IMapper<SearchInDirectoryResponse, SearchInDirectoryDTO> {

    override fun map(data: SearchInDirectoryResponse): SearchInDirectoryDTO {
        return SearchInDirectoryDTO(
            id = requireNotNull(data.id),
            text = requireNotNull(data.text),
            meanings = mapMeanings(requireNotNull(data.meanings))
        )
    }

    private fun mapMeanings(meanings: List<MeaningResponse>) =
        meanings
            .map(meaningModelMapper::map)
            .toList()

}

class MeaningModelMapper @Inject constructor(
    private val translationMapper: IMapper<TranslationResponse, TranslationDTO>,
    private val partOfSpeechCodeMapper: IMapper<String?, PartOfSpeech>
) : IMapper<MeaningResponse, MeaningDTO> {

    override fun map(data: MeaningResponse): MeaningDTO {
        return MeaningDTO(
            id = requireNotNull(data.id),
            translation = translationMapper.map(requireNotNull(data.translation)),
            transcription = data.transcription,
            partOfSpeech = partOfSpeechCodeMapper.map(data.partOfSpeechCode)
        )
    }

}

class TranslationModelMapper @Inject constructor() :
    IMapper<TranslationResponse, TranslationDTO> {

    override fun map(data: TranslationResponse): TranslationDTO {
        return TranslationDTO(
            text = requireNotNull(data.text),
            note = data.note
        )
    }

}

class PartOfSpeechMapper @Inject constructor(
    private val partOfSpeechCodeMap: Map<String, @JvmSuppressWildcards PartOfSpeech>
) : IMapper<String?, PartOfSpeech> {

    override fun map(data: String?) = if (data == null) PartOfSpeech.UNEXPECTED else
        partOfSpeechCodeMap[data.toLowerCase(Locale.ENGLISH)] ?: PartOfSpeech.UNEXPECTED

}
