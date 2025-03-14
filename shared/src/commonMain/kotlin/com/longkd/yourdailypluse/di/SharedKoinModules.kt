package com.longkd.yourdailypluse.di

import com.longkd.yourdailypluse.articles.di.articlesModule
import com.longkd.yourdailypluse.source.di.sourceModule

/**
 * @Author: longkd
 * @Since: 20:15 - 9/3/25
 */

val sharedKoinModule = listOf(
    articlesModule,
    sourceModule,
    networkModule
)