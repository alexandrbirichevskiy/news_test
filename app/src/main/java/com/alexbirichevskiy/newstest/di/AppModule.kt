package com.alexbirichevskiy.newstest.di

import com.alexbirichevskiy.newstest.domain.usecase.UseCase
import com.alexbirichevskiy.newstest.ui.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {

    @Provides
    fun provideMainViewModelFactory(useCase: UseCase): MainViewModelFactory {
        return MainViewModelFactory(useCase)
    }
}