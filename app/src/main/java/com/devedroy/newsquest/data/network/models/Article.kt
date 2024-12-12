package com.devedroy.newsquest.data.network.models


import com.google.gson.annotations.SerializedName
import com.devedroy.newsquest.domain.models.Article as DomainArticle

data class Article(
    @SerializedName("articles")
    val articles: List<Article> = listOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0
) {
    data class Article(
        @SerializedName("author")
        val author: String = "",
        @SerializedName("content")
        val content: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("publishedAt")
        val publishedAt: String = "",
        @SerializedName("source")
        val source: Source = Source(),
        @SerializedName("title")
        val title: String = "",
        @SerializedName("url")
        val url: String = "",
        @SerializedName("urlToImage")
        val urlToImage: String = ""
    ) {
        data class Source(
            @SerializedName("id")
            val id: String = "",
            @SerializedName("name")
            val name: String = ""
        )
    }
}

fun Article.toDomainArticles(): List<DomainArticle> {
    return articles.map { article ->
        DomainArticle(
            title = article.title,
            description = article.description,
            urlToImage = article.urlToImage,
            publishedDate = article.publishedAt,
            author = article.author,
            url = article.url
        )
    }
}
