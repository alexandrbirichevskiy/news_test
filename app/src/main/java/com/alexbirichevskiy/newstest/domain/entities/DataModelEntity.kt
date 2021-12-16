package com.alexbirichevskiy.newstest.domain.entities

data class DataModelEntity(
    val status: String,
    val articles: List<Article>,
    val totalResults: Int
)
