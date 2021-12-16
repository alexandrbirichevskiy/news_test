package com.alexbirichevskiy.newstest.data.repositoryImpl

import com.alexbirichevskiy.newstest.domain.entities.Article
import com.alexbirichevskiy.newstest.domain.repository.ArticleRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val localRepo: ArticleRepository,
    private val webRepo: ArticleRepository
) : ArticleRepository {

    override fun getData(): Observable<List<Article>> {
        val disp = webRepo.getData()
            .subscribeOn(Schedulers.io())
            .subscribe {
                it.forEach {
                    localRepo.put(it)
                }
            }
        return localRepo.getData()
    }

    override fun put(article: Article) {
        localRepo.put(article)
    }
}