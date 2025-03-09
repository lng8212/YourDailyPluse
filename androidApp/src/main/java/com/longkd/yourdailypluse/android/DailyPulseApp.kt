package com.longkd.yourdailypluse.android

import android.app.Application
import com.longkd.yourdailypluse.android.di.viewModelModule
import com.longkd.yourdailypluse.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @Author: longkd
 * @Since: 20:20 - 9/3/25
 */
class DailyPulseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelModule
        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}