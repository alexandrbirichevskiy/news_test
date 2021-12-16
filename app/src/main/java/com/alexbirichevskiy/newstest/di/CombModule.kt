package com.alexbirichevskiy.newstest.di

import com.alexbirichevskiy.newstest.data.repositoryImpl.ArticleRepositoryImpl
import com.alexbirichevskiy.newstest.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CombModule {

    @Provides
    fun provideArticleRepository(
        @Named("local") repositoryLocal: ArticleRepository,
        @Named("web") repositoryWeb: ArticleRepository
    ): ArticleRepository {
        return ArticleRepositoryImpl(localRepo = repositoryLocal, webRepo = repositoryWeb)
    }
}