package com.alexbirichevskiy.newstest.di

import android.content.Context
import androidx.room.Room
import com.alexbirichevskiy.newstest.data.ArticleDao
import com.alexbirichevskiy.newstest.data.ArticlesDb
import com.alexbirichevskiy.newstest.data.repositoryImpl.ArticleRepositoryDbImpl
import com.alexbirichevskiy.newstest.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DbModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    @Named("local")
    fun provideArticleRepository(articleDao: ArticleDao): ArticleRepository =
        ArticleRepositoryDbImpl(articleDao = articleDao)

    @Provides
    fun provideArticleDao(articlesDb: ArticlesDb): ArticleDao = articlesDb.articleDao()

    @Provides
    fun providesArticlesDb(context: Context, dbPath: String): ArticlesDb {
        return Room.databaseBuilder(
            context,
            ArticlesDb::class.java,
            dbPath
        ).build()
    }

    @Provides
    fun providesdbPath(): String = "articles.db"
}