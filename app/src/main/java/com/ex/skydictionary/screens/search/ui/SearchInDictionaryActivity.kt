package com.ex.skydictionary.screens.search.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.helpers.TEXT_CHANGE_DEBOUNCE
import com.ex.skydictionary.internal.helpers.plusAssign
import com.ex.skydictionary.internal.viewmodel.getViewModel
import com.ex.skydictionary.screens.search.di.SearchInDictionaryComponent
import com.ex.skydictionary.screens.search.presentation.ISearchInDirectoryViewModel
import com.ex.skydictionary.screens.search.presentation.SearchInDirectoryViewModel
import com.ex.skydictionary.screens.search.ui.adapter.DictionaryAdapter
import com.ex.skydictionary.screens.wordcard.ui.WordCardBottomSheet
import com.jakewharton.rxbinding3.widget.afterTextChangeEvents
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class SearchInDictionaryActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ISearchInDirectoryViewModel
    private val disposable = CompositeDisposable()

    private val adapter = DictionaryAdapter {
        WordCardBottomSheet.getInstance(it).show(supportFragmentManager, "tag")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SearchInDictionaryComponent.get(this).inject(this)
        viewModel = getViewModel<SearchInDirectoryViewModel>(viewModelFactory)
        initView()
        observeDictionaryChanges()
    }

    private fun initView() {
        search_input.requestFocus()
        dictionary_recycler_view.layoutManager = LinearLayoutManager(this)
        dictionary_recycler_view.adapter = adapter
    }

    private fun observeDictionaryChanges() {
        viewModel.dataForDictionary.observe(this, Observer {
            adapter.updateAll(it)
        })
    }

    override fun onResume() {
        super.onResume()
        observeSearchChanges()
    }

    override fun onPause() {
        super.onPause()
        unsubscribe()
    }

    private fun observeSearchChanges() {
        val (time, timeUnit, scheduler) = TEXT_CHANGE_DEBOUNCE
        disposable += search_input.afterTextChangeEvents()
            .skipInitialValue()
            .debounce(time, timeUnit, scheduler)
            .map { it.editable?.toString() ?: "" }
            .distinctUntilChanged()
            .filter(CharSequence::isNotEmpty)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewModel.search(it)
            }, {
                println()
            })
    }

    private fun unsubscribe() {
        disposable.dispose()
    }

}
