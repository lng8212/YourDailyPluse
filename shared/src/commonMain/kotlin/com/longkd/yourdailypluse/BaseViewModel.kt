package com.longkd.yourdailypluse

import kotlinx.coroutines.CoroutineScope

/**
 * @Author: longkd
 * @Since: 20:34 - 5/3/25
 */
expect open class BaseViewModel() {
    val scope: CoroutineScope
}