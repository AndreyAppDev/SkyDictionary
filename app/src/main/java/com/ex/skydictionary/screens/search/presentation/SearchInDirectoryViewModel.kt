package com.ex.skydictionary.screens.search.presentation

import com.ex.skydictionary.internal.helpers.plusAssign
import com.ex.skydictionary.internal.viewmodel.DisposableViewMode
import com.ex.skydictionary.screens.search.domain.ISearchInDictionaryInteractor
import com.ex.skydictionary.screens.search.domain.entities.request.SearchInDirectoryRequestDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchInDirectoryViewModel @Inject constructor(
    private val interactor: ISearchInDictionaryInteractor
) : DisposableViewMode(), ISearchInDirectoryViewModel {

    override fun search(query: String) {
        disposable += interactor.search(SearchInDirectoryRequestDTO(query))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                println()
            }, {
                println()
            })
    }


}
