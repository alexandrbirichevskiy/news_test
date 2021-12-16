package com.alexbirichevskiy.newstest.domain.usecase

import com.alexbirichevskiy.newstest.domain.entities.Article
import com.alexbirichevskiy.newstest.domain.repository.ArticleRepository
import io.reactivex.Observable
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: ArticleRepository) {
    fun getData(): Observable<List<Article>> {
        return repository.getData()
    }
}