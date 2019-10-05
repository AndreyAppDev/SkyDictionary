package com.ex.skydictionary.screens.search.di

import com.ex.skydictionary.internal.mapper.IMapper
import com.ex.skydictionary.screens.search.data.entities.MeaningResponse
import com.ex.skydictionary.screens.search.data.entities.SearchInDirectoryResponse
import com.ex.skydictionary.screens.search.data.entities.TranslationResponse
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.search.domain.entities.response.SearchInDirectoryDTO
import com.ex.skydictionary.screens.search.domain.entities.response.TranslationDTO
import com.ex.skydictionary.screens.search.domain.mapper.MeaningModelMapper
import com.ex.skydictionary.screens.search.domain.mapper.SearchInDirectoryModelMapper
import com.ex.skydictionary.screens.search.domain.mapper.TranslationModelMapper
import dagger.Binds
import dagger.Module

@Module
abstract class SearchInDirectoryModelMapperModule {

    @Binds
    abstract fun bindSearchInDirectoryModelMapper(mapper: SearchInDirectoryModelMapper):
            IMapper<SearchInDirectoryResponse, SearchInDirectoryDTO>

    @Binds
    abstract fun bindMeaningModelMapper(mapper: MeaningModelMapper): IMapper<MeaningResponse, MeaningDTO>

    @Binds
    abstract fun bindTranslationModelMapper(mapper: TranslationModelMapper): IMapper<TranslationResponse, TranslationDTO>

}
