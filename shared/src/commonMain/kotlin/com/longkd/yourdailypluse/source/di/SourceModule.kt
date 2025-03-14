package com.longkd.yourdailypluse.source.di

import com.longkd.yourdailypluse.source.data.SourceDataSource
import com.longkd.yourdailypluse.source.data.SourceRepository
import com.longkd.yourdailypluse.source.data.SourceService
import com.longkd.yourdailypluse.source.domain.SourceUseCase
import com.longkd.yourdailypluse.source.presentation.SourceViewModel
import org.koin.dsl.module

/**
 * @Author: longkd
 * @Since: 21:17 - 14/3/25
 */

val sourceModule = module {
    single<SourceService> {
        SourceService(get())
    }

    single<SourceDataSource> {
        SourceDataSource(get())
    }

    single<SourceRepository> {
        SourceRepository(get(), get())
    }

    single<SourceUseCase> {
        SourceUseCase(get())
    }

    single<SourceViewModel> {
        SourceViewModel(get())
    }
}