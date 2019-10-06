package com.ex.skydictionary.screens.wordcard.di

import androidx.lifecycle.ViewModel
import com.ex.skydictionary.internal.di.viewmodel.ViewModelKey
import com.ex.skydictionary.screens.wordcard.data.IWordMeaningsInfoRepository
import com.ex.skydictionary.screens.wordcard.data.WordMeaningsInfoRepository
import com.ex.skydictionary.screens.wordcard.domain.IWordMeaningsInfoInteractor
import com.ex.skydictionary.screens.wordcard.domain.WordMeaningsInfoInteractor
import com.ex.skydictionary.screens.wordcard.presentation.WordDetailInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WordMeaningsInfoModule {

    @Binds
    @IntoMap
    @ViewModelKey(WordDetailInfoViewModel::class)
    abstract fun bindViewModel(viewModel: WordDetailInfoViewModel): ViewModel

    @Binds
    abstract fun bindInteractor(iteractor: WordMeaningsInfoInteractor):
            IWordMeaningsInfoInteractor

    @Binds
    abstract fun bindRepo(repo: WordMeaningsInfoRepository):
            IWordMeaningsInfoRepository

}
