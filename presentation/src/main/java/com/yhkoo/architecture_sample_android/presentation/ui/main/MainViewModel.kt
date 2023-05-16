package com.yhkoo.architecture_sample_android.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.yhkoo.architecture_sample_android.di.MainDispatcher
import com.yhkoo.architecture_sample_android.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : BaseViewModel() {

    private val _event = MutableSharedFlow<MainViewEvent>()
    val event = _event.asSharedFlow()

    fun onClickMVVMButton() {
        viewModelScope.launch(mainDispatcher) {
            _event.emit(MainViewEvent.MVVM)
        }
    }

    fun onClickMVIButton() {
        viewModelScope.launch(mainDispatcher) {
            _event.emit(MainViewEvent.MVI)
        }
    }
}