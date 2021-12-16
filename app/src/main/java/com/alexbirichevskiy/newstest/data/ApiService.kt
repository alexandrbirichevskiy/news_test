package com.alexbirichevskiy.newstest.data

import com.alexbirichevskiy.newstest.domain.entities.DataModelEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=ru&pageSize=100&apiKey=a177625e9e8d4bd5bd2a69560d39715b")
    fun getDataModel(): Observable<DataModelEntity>
}