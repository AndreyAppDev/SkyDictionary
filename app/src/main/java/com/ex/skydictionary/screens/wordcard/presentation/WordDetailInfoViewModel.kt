package com.ex.skydictionary.screens.wordcard.presentation

import androidx.lifecycle.MutableLiveData
import com.ex.skydictionary.internal.helpers.plusAssign
import com.ex.skydictionary.internal.viewmodel.DisposableViewMode
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.wordcard.data.entities.request.WordMeaningsInfoRequest
import com.ex.skydictionary.screens.wordcard.domain.IWordMeaningsInfoInteractor
import com.ex.skydictionary.screens.wordcard.domain.entities.WordMeaningsDetailDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WordDetailInfoViewModel @Inject constructor(
    private val interactor: IWordMeaningsInfoInteractor
) : DisposableViewMode(), IWordDetailInfoViewModel {

    override val onDetailLoadLiveData = MutableLiveData<WordMeaningsDetailDTO>()

    override fun loadDetailInfo(meaningDTO: MeaningDTO) {
        val request = WordMeaningsInfoRequest(meaningDTO.id, 640)
        disposable += interactor.loadDetailInfo(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onDetailLoadLiveData.value = it
            }, {
                println()
            })
    }

}
