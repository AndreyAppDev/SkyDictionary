package com.ex.skydictionary.internal.di

import android.content.Context
import com.ex.skydictionary.internal.api.ISkyEngDictionaryApi
import com.ex.skydictionary.internal.api.RetrofitModule
import com.ex.skydictionary.internal.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class, ViewModelModule::class])
@Singleton
interface AppComponent {

    fun provideContext(): Context

    fun provideApi(): ISkyEngDictionaryApi

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun context(context: Context): Builder
    }

}
