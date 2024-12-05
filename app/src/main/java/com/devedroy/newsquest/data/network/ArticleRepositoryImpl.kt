package com.devedroy.newsquest.data.network

import com.devedroy.newsquest.domain.ArticleRepository
import com.devedroy.newsquest.domain.models.Article
import com.devedroy.newsquest.domain.utils.DataError
import com.devedroy.newsquest.domain.utils.NewsResult

class ArticleRepositoryImpl(
    private val newsService: NewsService
) : ArticleRepository {
    override suspend fun getArticles(): NewsResult<List<Article>, DataError.Network> {

    }

}