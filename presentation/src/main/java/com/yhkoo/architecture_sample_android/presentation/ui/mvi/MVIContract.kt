package com.yhkoo.architecture_sample_android.presentation.ui.mvi

import com.yhkoo.architecture_sample_android.presentation.base.BaseContract

interface MVIContract : BaseContract<MVIContract.State, MVIContract.Event, MVIContract.Effect> {

    data class State(
        val name: String = "",
        val imageUrl: String = ""
    )

    sealed interface Event {
        object RequestBeerInfo : Event
    }

    sealed interface Effect {
        data class ShowToast(val message: String) : Effect
    }
}