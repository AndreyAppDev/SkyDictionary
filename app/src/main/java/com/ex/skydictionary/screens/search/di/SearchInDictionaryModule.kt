package com.ex.skydictionary.screens.search.di

import androidx.lifecycle.ViewModel
import com.ex.skydictionary.internal.di.viewmodel.ViewModelKey
import com.ex.skydictionary.screens.search.data.ISearchInDictionaryRepository
import com.ex.skydictionary.screens.search.data.SearchInDictionaryRepository
import com.ex.skydictionary.screens.search.domain.ISearchInDictionaryInteractor
import com.ex.skydictionary.screens.search.domain.SearchInDictionaryInteractor
import com.ex.skydictionary.screens.search.presentation.SearchInDirectoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SearchInDictionaryModule {

    @Binds
    abstract fun bindRepo(repo: SearchInDictionaryRepository): ISearchInDictionaryRepository

    @Binds
    abstract fun bindInteractor(interactor: SearchInDictionaryInteractor): ISearchInDictionaryInteractor

    @Binds
    @IntoMap
    @ViewModelKey(SearchInDirectoryViewModel::class)
    abstract fun bindPresenter(viewModel: SearchInDirectoryViewModel): ViewModel

}
