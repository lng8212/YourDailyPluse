package com.longkd.yourdailypluse.db

import app.cash.sqldelight.db.SqlDriver

/**
 * @Author: longkd
 * @Since: 20:08 - 12/3/25
 */

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}