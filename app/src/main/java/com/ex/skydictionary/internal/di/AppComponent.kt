package com.ex.skydictionary.internal.di

import android.content.Context
import com.ex.skydictionary.internal.api.ISkyEngDictionaryApi
import com.ex.skydictionary.internal.api.RetrofitModule
import com.ex.skydictionary.internal.di.viewmodel.ViewModelModule
import com.ex.skydictionary.internal.helpers.PartOfSpeechCodeMapModule
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        RetrofitModule::class,
        ViewModelModule::class,
        PartOfSpeechCodeMapModule::class
    ]
)
@Singleton
interface AppComponent {

    fun provideContext(): Context

    fun provideApi(): ISkyEngDictionaryApi

    fun providePartOfSpeechMap(): Map<String, PartOfSpeech>

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun context(context: Context): Builder
    }

}
