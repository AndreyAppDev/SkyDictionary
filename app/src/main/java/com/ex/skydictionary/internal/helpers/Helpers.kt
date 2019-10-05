package com.ex.skydictionary.internal.helpers

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

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
