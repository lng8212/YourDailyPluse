package com.longkd.yourdailypluse.articles.data

import longkd.yourdailypluse.db.YourDailyPulseDatabase

/**
 * @Author: longkd
 * @Since: 21:52 - 10/3/25
 */

class ArticlesDataSource(private val database: YourDailyPulseDatabase) {
    fun getAllArticles(): List<ArticleRaw> =
        database.yourDailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.yourDailyPulseDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)

            }
        }
    }

    fun clearArticles() =
        database.yourDailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(article: ArticleRaw) {
        database.yourDailyPulseDatabaseQueries.insertArticle(
            title = article.title,
            desc = article.desc,
            date = article.date,
            imageUrl = article.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(title, desc, date, imageUrl)
}