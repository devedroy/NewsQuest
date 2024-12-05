package com.devedroy.newsquest.data.network

import com.devedroy.newsquest.data.network.models.Article
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {
    @GET("v2/top-headlines?country={country}")
    suspend fun getUsers(@Path("country") countryName: String): List<Article>
}