package com.longkd.yourdailypluse.source.presentation

import com.longkd.yourdailypluse.BaseViewModel
import com.longkd.yourdailypluse.source.domain.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * @Author: longkd
 * @Since: 21:19 - 14/3/25
 */
class SourceViewModel(private val useCase: SourceUseCase) : BaseViewModel() {
    private val _sourceState: MutableStateFlow<SourceState> =
        MutableStateFlow(SourceState(loading = true))
    val sourceState: StateFlow<SourceState>
        get() = _sourceState

    init {
        getAllSources()
    }

    fun getAllSources(forceFetch: Boolean = false) {
        scope.launch {
            _sourceState.emit(
                SourceState(
                    loading = true,
                    sources = _sourceState.value.sources
                )
            )
            val fetchedSources = useCase.getAllSources(forceFetch)
            _sourceState.emit(SourceState(sources = fetchedSources))
        }
    }
}