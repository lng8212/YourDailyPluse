package com.longkd.yourdailypluse.articles.domain

import com.longkd.yourdailypluse.articles.data.ArticleRaw
import com.longkd.yourdailypluse.articles.data.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

/**
 * @Author: longkd
 * @Since: 21:05 - 8/3/25
 */
class ArticlesUseCase(private val repo: ArticlesRepository) {
    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articlesRaw = repo.getArticles(forceFetch)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map {
        Article(
            it.title,
            it.desc ?: "Click to find out more",
            getDaysAgoString(it.date),
            it.imageUrl
                ?: "https://www.cnet.com/a/img/resize/54cc0d7481c3b4ba6cd1b5d7865f11c43feb1e75/hub/2024/09/30/ab904444-01d1-4d43-b94b-8d091f7ef01e/amazon-box-foreground.jpg?auto=webp&fit=crop&height=675&width=1200"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}