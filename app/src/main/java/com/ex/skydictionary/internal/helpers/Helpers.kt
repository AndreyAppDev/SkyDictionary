package com.ex.skydictionary.internal.helpers

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

val TEXT_CHANGE_DEBOUNCE = Triple(300L, TimeUnit.MILLISECONDS, Schedulers.computation())

fun <R> suppressException(block: () -> R, defaultVal: R): R {
    return try {
        block()
    } catch (ex: Throwable) {
        defaultVal
    }
}

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    this.add(disposable)
}
