package com.ex.skydictionary.internal.extensions

import android.content.Context
import com.ex.skydictionary.internal.app.SkyDictinoryApp

val Context.appComponent
    get() = (this.applicationContext as SkyDictinoryApp).appComponent