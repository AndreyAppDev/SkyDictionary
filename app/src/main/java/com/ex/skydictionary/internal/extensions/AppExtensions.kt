package com.ex.skydictionary.internal.extensions

import android.annotation.SuppressLint
import android.content.Context
import com.ex.skydictionary.internal.app.SkyDictinoryApp

val Context.appComponent
    get() = (this.applicationContext as SkyDictinoryApp).appComponent

@SuppressLint("DefaultLocale")
fun String.capsFistChar() = this.capitalize()
