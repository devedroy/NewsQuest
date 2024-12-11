package com.devedroy.newsquest.di

import com.devedroy.newsquest.data.network.ArticleRepositoryImpl
import com.devedroy.newsquest.domain.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: ArticleRepositoryImpl): ArticleRepository
}