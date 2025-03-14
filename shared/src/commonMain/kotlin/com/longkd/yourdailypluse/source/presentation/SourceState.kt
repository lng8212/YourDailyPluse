package com.longkd.yourdailypluse.source.presentation

import com.longkd.yourdailypluse.source.domain.Source

/**
 * @Author: longkd
 * @Since: 21:19 - 14/3/25
 */
data class SourceState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)