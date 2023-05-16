package com.yhkoo.architecture_sample_android.presentation.ui.main

sealed interface MainViewEvent {
    object MVVM : MainViewEvent
    object MVI : MainViewEvent
}