package com.alexbirichevskiy.newstest.data.repositoryImpl

import com.alexbirichevskiy.newstest.data.ArticleDao
import com.alexbirichevskiy.newstest.domain.entities.Article
import com.alexbirichevskiy.newstest.domain.repository.ArticleRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArticleRepositoryDbImpl @Inject constructor(private val articleDao: ArticleDao) :
    ArticleRepository {

    override fun getData(): Observable<List<Article>> {
        return articleDao.getArticles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun put(article: Article) {
        val disp = articleDao.getUrl()
            .subscribeOn(Schedulers.io())
            .subscribe {
                if (!it.contains(article.url)) {
                    articleDao.put(article)
                        .subscribeOn(Schedulers.io())
                        .subscribe()
                }
            }
    }
}