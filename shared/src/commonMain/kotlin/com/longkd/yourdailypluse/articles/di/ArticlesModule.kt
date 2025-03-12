package com.longkd.yourdailypluse.articles.di

import com.longkd.yourdailypluse.articles.data.ArticlesDataSource
import com.longkd.yourdailypluse.articles.data.ArticlesRepository
import com.longkd.yourdailypluse.articles.data.ArticlesService
import com.longkd.yourdailypluse.articles.domain.ArticlesUseCase
import com.longkd.yourdailypluse.articles.presentation.ArticlesViewModel
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

    single<ArticlesDataSource> {
        ArticlesDataSource(get())
    }

    single<ArticlesRepository> {
        ArticlesRepository(get(), get())
    }

}