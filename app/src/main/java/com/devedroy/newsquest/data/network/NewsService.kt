package com.devedroy.newsquest.data.network

import com.devedroy.newsquest.data.network.models.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines?country=us")
    suspend fun getUsers(@Query("apiKey") apiKey: String): Response<Article>
}