package com.alexbirichevskiy.newstest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexbirichevskiy.newstest.domain.usecase.UseCase

class MainViewModelFactory(private val useCase: UseCase) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(useCase) as T
    }
}