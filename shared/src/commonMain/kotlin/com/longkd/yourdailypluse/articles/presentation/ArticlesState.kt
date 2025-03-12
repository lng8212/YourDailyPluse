package com.longkd.yourdailypluse.articles.presentation

import com.longkd.yourdailypluse.articles.domain.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)