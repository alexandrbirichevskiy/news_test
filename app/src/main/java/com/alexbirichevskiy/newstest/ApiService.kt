package com.alexbirichevskiy.newstest

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("top-headlines?country=ru&pageSize=100&apiKey=a177625e9e8d4bd5bd2a69560d39715b")
    fun getDataModel(): Single<DataModel>
}