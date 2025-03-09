package com.longkd.yourdailypluse.articles.di

import com.longkd.yourdailypluse.articles.ArticlesService
import com.longkd.yourdailypluse.articles.ArticlesUseCase
import com.longkd.yourdailypluse.articles.ArticlesViewModel
import org.koin.dsl.module

/**
 * @Author: longkd
 * @Since: 20:05 - 9/3/25
 */

val articlesModule = module {

    single<ArticlesService> {
        ArticlesService(get())
    }

    single<ArticlesUseCase> {
        ArticlesUseCase(get())
    }

    single<ArticlesViewModel> {
        ArticlesViewModel(get())
    }

}