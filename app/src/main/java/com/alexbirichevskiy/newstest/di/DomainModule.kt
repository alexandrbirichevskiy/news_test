package com.alexbirichevskiy.newstest.di

import com.alexbirichevskiy.newstest.domain.repository.ArticleRepository
import com.alexbirichevskiy.newstest.domain.usecase.UseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideUseCase(articleRepository: ArticleRepository): UseCase {
        return UseCase(articleRepository)
    }
}