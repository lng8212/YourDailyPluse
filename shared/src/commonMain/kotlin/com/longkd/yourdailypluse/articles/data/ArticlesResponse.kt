package com.longkd.yourdailypluse.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author: longkd
 * @Since: 20:31 - 8/3/25
 */

@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    @SerialName("articles")
    val articles: List<ArticleRaw>
)
