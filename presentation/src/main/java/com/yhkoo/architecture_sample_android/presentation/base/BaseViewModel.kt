package com.yhkoo.architecture_sample_android.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {
    
    protected fun launchWithErrorHandling(
        onError: (Throwable) -> Unit = { Timber.e(it) },
        block: suspend () -> Unit
    ) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
    
    protected fun <T> createStateFlow(initialValue: T): MutableStateFlow<T> {
        return MutableStateFlow(initialValue)
    }
    
    protected fun <T> MutableStateFlow<T>.asReadOnlyStateFlow(): StateFlow<T> {
        return this.asStateFlow()
    }
}