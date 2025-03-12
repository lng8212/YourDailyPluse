package com.longkd.yourdailypluse.android.di

import app.cash.sqldelight.db.SqlDriver
import com.longkd.yourdailypluse.db.DatabaseDriverFactory
import longkd.yourdailypluse.db.YourDailyPulseDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @Author: longkd
 * @Since: 20:15 - 12/3/25
 */

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()
    }
    single<YourDailyPulseDatabase> {
        YourDailyPulseDatabase(get())
    }
}