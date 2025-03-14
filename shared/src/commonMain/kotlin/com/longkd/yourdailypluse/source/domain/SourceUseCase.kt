package com.longkd.yourdailypluse.source.domain

import com.longkd.yourdailypluse.source.data.SourceRepository

/**
 * @Author: longkd
 * @Since: 21:14 - 14/3/25
 */
class SourceUseCase(private val sourceRepository: SourceRepository) {
    suspend fun getAllSources(forceFetch: Boolean = false): List<Source> =
        sourceRepository.getSources(forceFetch).map {
            Source(it.name, it.description, it.country + "-" + it.language)
        }
}