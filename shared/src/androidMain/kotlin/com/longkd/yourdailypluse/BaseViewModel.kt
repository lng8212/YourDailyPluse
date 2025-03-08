package com.longkd.yourdailypluse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

/**
 * @Author: longkd
 * @Since: 20:36 - 5/3/25
 */
actual open class BaseViewModel : ViewModel() {
    actual val scope: CoroutineScope
        get() = viewModelScope

}