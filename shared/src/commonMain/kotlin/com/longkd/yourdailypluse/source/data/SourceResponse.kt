package com.longkd.yourdailypluse.source.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author: longkd
 * @Since: 20:56 - 14/3/25
 */
@Serializable
data class SourceResponse(
    @SerialName("status")
    val status: String,
    @SerialName("sources")
    val sources: List<SourceRaw>
)