package com.longkd.yourdailypluse.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author: longkd
 * @Since: 20:52 - 8/3/25
 */
@Serializable
data class ArticleRaw(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val desc: String?,
    @SerialName("publishedAt")
    val date: String,
    @SerialName("urlToImage")
    val imageUrl: String?
)