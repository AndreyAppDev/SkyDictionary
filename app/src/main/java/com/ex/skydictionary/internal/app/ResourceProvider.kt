package com.ex.skydictionary.internal.app

import android.content.Context
import javax.inject.Inject

class ResourceProvider @Inject constructor(
    private val context: Context
) : IResourceProvider {

    override fun getString(resId: Int): String {
        return context.getString(resId)
    }

}
