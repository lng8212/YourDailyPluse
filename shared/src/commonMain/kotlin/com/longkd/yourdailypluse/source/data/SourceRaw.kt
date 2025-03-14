package com.longkd.yourdailypluse.source.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author: longkd
 * @Since: 20:52 - 14/3/25
 */

@Serializable
data class SourceRaw(
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String?,
    @SerialName("language")
    val language: String,
    @SerialName("country")
    val country: String
)