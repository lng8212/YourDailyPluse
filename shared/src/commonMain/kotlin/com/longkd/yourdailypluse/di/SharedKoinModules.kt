package com.longkd.yourdailypluse.di

import com.longkd.yourdailypluse.articles.di.articlesModule

/**
 * @Author: longkd
 * @Since: 20:15 - 9/3/25
 */

val sharedKoinModule = listOf(
    articlesModule,
    networkModule
)