package com.devedroy.newsquest.domain.models

data class Article(
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val publishedDate: String?,
    val author: String?
)