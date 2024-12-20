package com.devedroy.newsquest.presentation.articles_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devedroy.newsquest.domain.ArticleRepository
import com.devedroy.newsquest.domain.models.Article
import com.devedroy.newsquest.domain.utils.NewsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    init {
        getArticlesList()
    }

    fun getArticlesList() {
        viewModelScope.launch {
            when (val result = repository.getArticles()) {
                is NewsResult.Error -> {
                    Log.wtf("ArticlesViewModel", "getArticlesList: Network error")
                }

                is NewsResult.Success -> {
                    Log.wtf("ArticlesViewModel", "getArticlesList: ${result.data}")
                    _articles.update { result.data }
                }
            }
        }
    }
}