package com.ex.skydictionary.internal.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable

abstract class DisposableViewMode : ViewModel() {

    val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}

inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory) =
    ViewModelProviders.of(this, viewModelFactory).get(T::class.java)

inline fun <T> LiveData<T>.observe(
    lifecycleOwner: LifecycleOwner,
    crossinline onHandleContent: (T?) -> Unit
) {
    observe(lifecycleOwner, Observer { onHandleContent(it) })
}
