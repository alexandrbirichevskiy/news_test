package com.alexbirichevskiy.newstest.di

import com.alexbirichevskiy.newstest.ui.MainActivity
import dagger.Component

@Component(modules = [DbModule::class, WebModule::class, CombModule::class, DomainModule::class, AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}