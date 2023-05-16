package com.yhkoo.architecture_sample_android.presentation.ui.mvvm

import androidx.lifecycle.viewModelScope
import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import com.yhkoo.architecture_sample_android.domain.usecase.GetBeerInfoUseCase
import com.yhkoo.architecture_sample_android.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class MVVMViewModel @Inject constructor(
    private val getBeerInfoUseCase: GetBeerInfoUseCase,
) : BaseViewModel() {

    private val _event = MutableSharedFlow<MVVMViewEvent>()
    val event = _event.asSharedFlow()

    private val _beerInfo = MutableStateFlow(BeerInfo.default)
    val beerInfo = _beerInfo.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.Main) {
            _event.emit(MVVMViewEvent.BeerList)
        }
    }

    fun getBeerList() {
        viewModelScope.launch(Dispatchers.IO) {
            getBeerInfoUseCase().onEach {
                _beerInfo.emit(it.first())
            }.launchIn(viewModelScope)
        }
    }
}