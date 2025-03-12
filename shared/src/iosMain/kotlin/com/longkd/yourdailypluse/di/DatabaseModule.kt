package com.longkd.yourdailypluse.di

import app.cash.sqldelight.db.SqlDriver
import com.longkd.yourdailypluse.db.DatabaseDriverFactory
import longkd.yourdailypluse.db.YourDailyPulseDatabase
import org.koin.dsl.module

/**
 * @Author: longkd
 * @Since: 20:23 - 12/3/25
 */

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory().createDriver()
    }

    single<YourDailyPulseDatabase> {
        YourDailyPulseDatabase(get())
    }
}