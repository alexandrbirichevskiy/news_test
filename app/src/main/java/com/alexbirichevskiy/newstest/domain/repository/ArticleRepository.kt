package com.alexbirichevskiy.newstest.domain.repository

import com.alexbirichevskiy.newstest.domain.entities.Article
import io.reactivex.Observable

interface ArticleRepository {
    fun getData(): Observable<List<Article>>
    fun put(article: Article)
}