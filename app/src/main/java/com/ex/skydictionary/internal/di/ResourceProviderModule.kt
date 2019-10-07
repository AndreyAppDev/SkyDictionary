package com.ex.skydictionary.internal.di

import com.ex.skydictionary.internal.app.IResourceProvider
import com.ex.skydictionary.internal.app.ResourceProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ResourceProviderModule {

    @Binds
    abstract fun bindResourceProvider(provider: ResourceProvider): IResourceProvider

}
