package com.yhkoo.architecture_sample_android.presentation.ui.mvvm

sealed interface MVVMViewEvent {
    object BeerList : MVVMViewEvent
}