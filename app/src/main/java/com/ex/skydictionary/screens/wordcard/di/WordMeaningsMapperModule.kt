package com.ex.skydictionary.screens.wordcard.di

import com.ex.skydictionary.internal.mapper.IMapper
import com.ex.skydictionary.screens.wordcard.data.entities.response.*
import com.ex.skydictionary.screens.wordcard.domain.entities.*
import com.ex.skydictionary.screens.wordcard.domain.mappers.*
import dagger.Binds
import dagger.Module

@Module
abstract class WordMeaningsMapperModule {

    @Binds
    abstract fun bindWordMeaningsDetailMapper(mapper: WordMeaningsDetailMapper):
            IMapper<WordMeaningDetailResponse, WordMeaningsDetailDTO>

    @Binds
    abstract fun bindWordImageMapper(mapper: WordImageMapper):
            IMapper<ImageResponse?, WordMeaningImageDTO?>

    @Binds
    abstract fun bindDefinitionsMapper(mapper: DefinitionsMapper):
            IMapper<DefinitionResponse, WordDefinitionDTO>

    @Binds
    abstract fun bindWordMeaningExampleMapper(mapper: WordMeaningExampleMapper):
            IMapper<WordMeaningExampleResponse, WordMeaningExampleDTO>

    @Binds
    abstract fun bindMeaningWithSimilarTranslationMapper(mapper: MeaningWithSimilarTranslationMapper):
            IMapper<MeaningsWithSimilarTranslationResponse, MeaningsWithSimilarTranslationDTO>

    @Binds
    abstract fun bindAlternativeTranslationsMapper(mapper: AlternativeTranslationsMapper):
            IMapper<AlternativeTranslationsResponse, AlternativeTranslationsDTO>

}
