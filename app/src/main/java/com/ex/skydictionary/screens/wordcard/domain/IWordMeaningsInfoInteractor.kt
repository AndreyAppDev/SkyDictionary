package com.ex.skydictionary.screens.wordcard.domain

import com.ex.skydictionary.screens.wordcard.data.entities.request.WordMeaningsInfoRequest
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningsDetailDTO
import io.reactivex.Single

interface IWordMeaningsInfoInteractor {
    fun loadDetailInfo(request: WordMeaningsInfoRequest): Single<WordMeaningsDetailDTO>
}
