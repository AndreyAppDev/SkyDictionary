package com.ex.skydictionary.screens.wordcard.data

import com.ex.skydictionary.internal.api.ISkyEngDictionaryApi
import com.ex.skydictionary.screens.wordcard.data.entities.request.WordMeaningsInfoRequest
import com.ex.skydictionary.screens.wordcard.data.entities.response.WordMeaningDetailResponse
import io.reactivex.Single
import javax.inject.Inject

class WordMeaningsInfoRepository @Inject constructor(
    private val api: ISkyEngDictionaryApi
) : IWordMeaningsInfoRepository {

    override fun loadWordMeaningsDetails(request: WordMeaningsInfoRequest): Single<WordMeaningDetailResponse> {
        return api.loadWordMeaningsDetailInfo(request.wordId)
            .flatMap { Single.just(it.first()) }
    }

}
