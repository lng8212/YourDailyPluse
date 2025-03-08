package com.longkd.yourdailypluse

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

/**
 * @Author: longkd
 * @Since: 20:38 - 5/3/25
 */
actual open class BaseViewModel {

    actual val scope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)

    fun clear(){
        scope.cancel()
    }
}