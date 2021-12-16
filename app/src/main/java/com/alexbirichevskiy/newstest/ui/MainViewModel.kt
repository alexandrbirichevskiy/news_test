package com.alexbirichevskiy.newstest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexbirichevskiy.newstest.domain.entities.Article
import com.alexbirichevskiy.newstest.domain.usecase.UseCase
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val useCase: UseCase) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val data = MutableLiveData<List<Article>>()

    fun loadData() {
        compositeDisposable.add(
            useCase.getData()
                .subscribe {
                    data.value = it
                })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}