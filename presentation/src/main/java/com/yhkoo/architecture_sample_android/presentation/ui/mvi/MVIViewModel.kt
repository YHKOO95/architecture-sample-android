package com.yhkoo.architecture_sample_android.presentation.ui.mvi

import androidx.lifecycle.viewModelScope
import com.yhkoo.architecture_sample_android.domain.usecase.GetBeerInfoUseCase
import com.yhkoo.architecture_sample_android.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MVIViewModel @Inject constructor(
    private val getBeerInfoUseCase: GetBeerInfoUseCase,
) : BaseViewModel(), MVIContract {

    private val _state = MutableStateFlow(MVIContract.State())
    override val state: StateFlow<MVIContract.State> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<MVIContract.Effect>()
    override val effect: SharedFlow<MVIContract.Effect> = _effect.asSharedFlow()

    override fun event(event: MVIContract.Event) {
        when (event) {
            MVIContract.Event.RequestBeerInfo -> {
                getBeerList()
            }
        }
    }

    private fun getBeerList() {
        viewModelScope.launch(Dispatchers.IO) {
            getBeerInfoUseCase().onEach { list ->
                if (list.isEmpty()) {
                    _effect.emit(MVIContract.Effect.ShowToast("리스트가 비어있습니다."))
                } else {
                    _state.update {
                        it.copy(
                            name = list.first().name,
                            imageUrl = list.first().imageUrl
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}