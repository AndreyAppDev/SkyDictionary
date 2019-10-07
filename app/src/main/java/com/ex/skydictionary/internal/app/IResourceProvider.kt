package com.ex.skydictionary.internal.app

import androidx.annotation.StringRes

interface IResourceProvider {
    fun getString(@StringRes resId: Int): String
}