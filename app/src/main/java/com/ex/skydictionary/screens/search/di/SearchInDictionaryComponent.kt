package com.ex.skydictionary.screens.search.di

import androidx.appcompat.app.AppCompatActivity
import com.ex.skydictionary.internal.di.ActivityScope
import com.ex.skydictionary.internal.di.AppComponent
import com.ex.skydictionary.internal.di.viewmodel.ViewModelModule
import com.ex.skydictionary.internal.extensions.appComponent
import com.ex.skydictionary.internal.helpers.PartOfSpeechCodeMapModule
import com.ex.skydictionary.screens.search.ui.SearchInDictionaryActivity
import dagger.Component

@Component(
    modules = [
        SearchInDictionaryModule::class,
        PartOfSpeechCodeMapModule::class,
        SearchInDirectoryModelMapperModule::class,
        ViewModelModule::class
    ],
    dependencies = [AppComponent::class]
)
@ActivityScope
interface SearchInDictionaryComponent {

    fun inject(activity: SearchInDictionaryActivity)

    companion object {
        fun get(activity: AppCompatActivity): SearchInDictionaryComponent {
            return DaggerSearchInDictionaryComponent.builder()
                .appComponent(activity.appComponent)
                .build()
        }
    }

}
