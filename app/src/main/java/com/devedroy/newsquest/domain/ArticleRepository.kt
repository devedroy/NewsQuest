package com.devedroy.newsquest.domain

import com.devedroy.newsquest.domain.models.Article
import com.devedroy.newsquest.domain.utils.DataError
import com.devedroy.newsquest.domain.utils.NewsResult

interface ArticleRepository {
    suspend fun getArticles(): NewsResult<List<Article>, DataError.Network>
}