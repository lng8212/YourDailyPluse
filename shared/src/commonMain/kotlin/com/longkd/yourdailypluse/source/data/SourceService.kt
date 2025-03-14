package com.longkd.yourdailypluse.source.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * @Author: longkd
 * @Since: 20:24 - 14/3/25
 */
class SourceService(private val httpClient: HttpClient) {

    private val apiKey = "724f86aa6646444ba10a23a4e9f24e86"

    suspend fun fetchAllSource(): List<SourceRaw> {
        val response: SourceResponse =
            httpClient
                .get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey")
                .body()
        return response.sources
    }
}