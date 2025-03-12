package com.longkd.yourdailypluse.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import longkd.yourdailypluse.db.YourDailyPulseDatabase

/**
 * @Author: longkd
 * @Since: 20:09 - 12/3/25
 */
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        schema = YourDailyPulseDatabase.Schema,
        context = context,
        name = "YourDailyPulse.Database.db"
    )
}