package com.alexbirichevskiy.newstest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alexbirichevskiy.newstest.domain.entities.Article
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getArticles(): Observable<List<Article>>

    @Query("SELECT url FROM articles")
    fun getUrl(): Observable<List<String>>

    @Query("DELETE FROM articles")
    fun deleteAll(): Completable

    @Insert
    fun put(article: Article): Completable

}