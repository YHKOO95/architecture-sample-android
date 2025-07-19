package com.yhkoo.architecture_sample_android.presentation.ui.mvvm

import androidx.lifecycle.viewModelScope
import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import com.yhkoo.architecture_sample_android.domain.usecase.GetBeerInfoUseCase
import com.yhkoo.architecture_sample_android.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class MVVMViewModel @Inject constructor(
    private val getBeerInfoUseCase: GetBeerInfoUseCase,
) : BaseViewModel() {

    private val _event = MutableSharedFlow<MVVMViewEvent>()
    val event = _event.asSharedFlow()

    private val _beerInfo = MutableStateFlow(BeerInfo.default)
    val beerInfo = _beerInfo.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        loadBeerInfo()
    }

    fun loadBeerInfo() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                
                getBeerInfoUseCase().onEach { beerList ->
                    if (beerList.isNotEmpty()) {
                        _beerInfo.value = beerList.first()
                        _event.emit(MVVMViewEvent.BeerList)
                    } else {
                        _error.value = "맥주 정보를 찾을 수 없습니다."
                    }
                }.catch { exception ->
                    Timber.e(exception, "Failed to load beer info")
                    _error.value = "데이터를 불러오는데 실패했습니다: ${exception.message}"
                }.launchIn(viewModelScope)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _error.value = null
    }
}