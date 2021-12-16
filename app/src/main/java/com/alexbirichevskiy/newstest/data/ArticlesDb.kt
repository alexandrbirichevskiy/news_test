package com.alexbirichevskiy.newstest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexbirichevskiy.newstest.domain.entities.Article

@Database(
    version = 1,
    entities = [Article::class],
)
abstract class ArticlesDb : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}