package com.ex.skydictionary.internal.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: CommonViewModelFactory): ViewModelProvider.Factory

}
