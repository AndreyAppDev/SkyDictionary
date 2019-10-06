package com.ex.skydictionary.screens.wordcard.domain

import com.ex.skydictionary.internal.mapper.IMapper
import com.ex.skydictionary.screens.wordcard.data.IWordMeaningsInfoRepository
import com.ex.skydictionary.screens.wordcard.data.entities.request.WordMeaningsInfoRequest
import com.ex.skydictionary.screens.wordcard.data.entities.response.WordMeaningDetailResponse
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningsDetailDTO
import io.reactivex.Single
import javax.inject.Inject

class WordMeaningsInfoInteractor @Inject constructor(
    private val repo: IWordMeaningsInfoRepository,
    private val mapper: IMapper<WordMeaningDetailResponse, WordMeaningsDetailDTO>
) : IWordMeaningsInfoInteractor {

    override fun loadDetailInfo(request: WordMeaningsInfoRequest): Single<WordMeaningsDetailDTO> {
        return repo.loadWordMeaningsDetails(request).map(mapper::map)
    }

}
