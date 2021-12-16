package com.alexbirichevskiy.newstest.di

import com.alexbirichevskiy.newstest.data.repositoryImpl.ArticleRepositoryWebImpl
import com.alexbirichevskiy.newstest.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class WebModule {

    @Provides
    @Named("web")
    fun provideArticleRepository(): ArticleRepository = ArticleRepositoryWebImpl()
}