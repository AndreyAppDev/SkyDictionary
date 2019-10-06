package com.ex.skydictionary.screens.wordcard.presentation

import androidx.lifecycle.LiveData
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningsDetailDTO

interface IWordDetailInfoViewModel {

    val onDetailLoadLiveData: LiveData<WordMeaningsDetailDTO>

    fun loadDetailInfo(meaningDTO: MeaningDTO)

}
