package com.yhkoo.architecture_sample_android.presentation.ui.mvi

import androidx.lifecycle.viewModelScope
import com.yhkoo.architecture_sample_android.domain.usecase.GetBeerInfoUseCase
import com.yhkoo.architecture_sample_android.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

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
                loadBeerInfo()
            }
        }
    }

    private fun loadBeerInfo() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true, error = null) }
                
                getBeerInfoUseCase().onEach { beerList ->
                    if (beerList.isNotEmpty()) {
                        val beer = beerList.first()
                        _state.update {
                            it.copy(
                                name = beer.name,
                                imageUrl = beer.imageUrl,
                                isLoading = false,
                                error = null
                            )
                        }
                    } else {
                        _state.update { it.copy(isLoading = false, error = "맥주 정보를 찾을 수 없습니다.") }
                        _effect.emit(MVIContract.Effect.ShowToast("맥주 정보를 찾을 수 없습니다."))
                    }
                }.catch { exception ->
                    Timber.e(exception, "Failed to load beer info")
                    _state.update { 
                        it.copy(
                            isLoading = false, 
                            error = "데이터를 불러오는데 실패했습니다: ${exception.message}"
                        ) 
                    }
                    _effect.emit(MVIContract.Effect.ShowToast("데이터를 불러오는데 실패했습니다."))
                }.launchIn(viewModelScope)
            } catch (e: Exception) {
                Timber.e(e, "Unexpected error in loadBeerInfo")
                _state.update { 
                    it.copy(
                        isLoading = false, 
                        error = "예상치 못한 오류가 발생했습니다." 
                    ) 
                }
            }
        }
    }
}