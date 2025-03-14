package com.longkd.yourdailypluse.android.di

import com.longkd.yourdailypluse.articles.presentation.ArticlesViewModel
import com.longkd.yourdailypluse.source.presentation.SourceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @Author: longkd
 * @Since: 20:18 - 9/3/25
 */


val viewModelModule = module {
    viewModel {
        ArticlesViewModel(get())
        SourceViewModel(get())
    }
}