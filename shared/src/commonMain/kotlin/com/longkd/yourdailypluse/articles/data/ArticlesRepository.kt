package com.longkd.yourdailypluse.articles.data

/**
 * @Author: longkd
 * @Since: 22:11 - 10/3/25
 */
class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) {
            dataSource.clearArticles()
            return fetchArticles()
        }
        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} from database")
        if (articlesDb.isEmpty()) {
            return fetchArticles()
        }
        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}