package com.ex.skydictionary.internal.app

import android.app.Application
import com.ex.skydictionary.internal.di.AppComponent
import com.ex.skydictionary.internal.di.DaggerAppComponent

class SkyDictinoryApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }
}
