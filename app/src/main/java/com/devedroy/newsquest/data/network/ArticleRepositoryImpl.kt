package com.devedroy.newsquest.data.network

import com.devedroy.newsquest.BuildConfig
import com.devedroy.newsquest.data.network.models.toDomainArticles
import com.devedroy.newsquest.domain.ArticleRepository
import com.devedroy.newsquest.domain.models.Article
import com.devedroy.newsquest.domain.utils.DataError
import com.devedroy.newsquest.domain.utils.NewsResult
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : ArticleRepository {
    private val apiKey = BuildConfig.API_KEY
    override suspend fun getArticles(): NewsResult<List<Article>, DataError.Network> {
        val response = newsService.getUsers(apiKey)

        if (response.isSuccessful) {
            val articles = response.body()

            return if (articles != null) {
                NewsResult.Success(articles.toDomainArticles())
            } else {
                NewsResult.Success(emptyList())
            }
        } else {
            return NewsResult.Error(DataError.Network.UNKNOWN)
        }
    }

}