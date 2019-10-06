package com.ex.skydictionary.screens.wordcard.data

import com.ex.skydictionary.screens.wordcard.data.entities.request.WordMeaningsInfoRequest
import com.ex.skydictionary.screens.wordcard.data.entities.response.WordMeaningDetailResponse
import io.reactivex.Single

interface IWordMeaningsInfoRepository {
    fun loadWordMeaningsDetails(request: WordMeaningsInfoRequest): Single<WordMeaningDetailResponse>
}
