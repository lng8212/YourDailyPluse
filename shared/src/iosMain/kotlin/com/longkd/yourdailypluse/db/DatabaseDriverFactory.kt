package com.longkd.yourdailypluse.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import longkd.yourdailypluse.db.YourDailyPulseDatabase

/**
 * @Author: longkd
 * @Since: 20:12 - 12/3/25
 */
actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver = NativeSqliteDriver(
        schema = YourDailyPulseDatabase.Schema,
        name = "YourDailyPulse.Database.db"
    )
}