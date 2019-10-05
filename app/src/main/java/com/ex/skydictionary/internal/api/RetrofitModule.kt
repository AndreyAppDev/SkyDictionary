package com.ex.skydictionary.internal.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SKY_ENG_DICTIONARY_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSkyEngDictionaryApi(retrofit: Retrofit): ISkyEngDictionaryApi =
        retrofit.create(ISkyEngDictionaryApi::class.java)

    companion object {
        const val SKY_ENG_DICTIONARY_URL = "https://dictionary.skyeng.ru/"
    }

}
