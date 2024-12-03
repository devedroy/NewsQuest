package com.devedroy.newsquest.domain

data class Article(
    val title: String,
    val description: String,
    val urlToImage: String,
    val content: String,
    val author: String
)