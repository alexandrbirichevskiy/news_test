package com.alexbirichevskiy.newstest;

import android.app.Application;
import com.alexbirichevskiy.newstest.di.AppComponent
import com.alexbirichevskiy.newstest.di.AppModule
import com.alexbirichevskiy.newstest.di.DaggerAppComponent
import com.alexbirichevskiy.newstest.di.DbModule

class App : Application() {
    lateinit var appComponent : AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .dbModule(DbModule(this))
            .build()
    }

}
