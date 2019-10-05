package com.ex.skydictionary.screens.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ex.skydictionary.internal.viewmodel.getViewModel
import com.ex.skydictionary.screens.search.di.SearchInDictionaryComponent
import com.ex.skydictionary.screens.search.presentation.ISearchInDirectoryViewModel
import com.ex.skydictionary.screens.search.presentation.SearchInDirectoryViewModel
import javax.inject.Inject

class SearchInDictionaryActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ISearchInDirectoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchInDictionaryComponent.get(this).inject(this)
        viewModel = getViewModel<SearchInDirectoryViewModel>(viewModelFactory)
        viewModel.search("message")
    }
}
