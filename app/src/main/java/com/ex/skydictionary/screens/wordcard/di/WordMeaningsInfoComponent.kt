package com.ex.skydictionary.screens.wordcard.di

import androidx.fragment.app.Fragment
import com.ex.skydictionary.internal.di.AppComponent
import com.ex.skydictionary.internal.di.BottomSheetScope
import com.ex.skydictionary.internal.di.viewmodel.ViewModelModule
import com.ex.skydictionary.internal.extensions.appComponent
import com.ex.skydictionary.screens.search.di.SearchInDirectoryModelMapperModule
import com.ex.skydictionary.screens.wordcard.ui.WordCardBottomSheet
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [
        SearchInDirectoryModelMapperModule::class,
        WordMeaningsMapperModule::class,
        WordMeaningsInfoModule::class,
        ViewModelModule::class
    ]
)
@BottomSheetScope
interface WordMeaningsInfoComponent {

    fun inject(fragment: WordCardBottomSheet)

    companion object {
        fun getComponent(fragment: Fragment): WordMeaningsInfoComponent {
            return DaggerWordMeaningsInfoComponent.builder()
                .appComponent(fragment.requireContext().appComponent)
                .build()
        }
    }

}
