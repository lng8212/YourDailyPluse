package com.longkd.yourdailypluse.di

import com.longkd.yourdailypluse.articles.presentation.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

/**
 * @Author: longkd
 * @Since: 20:32 - 9/3/25
 */

fun initKoin() {
    val modules = sharedKoinModule + databaseModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}
