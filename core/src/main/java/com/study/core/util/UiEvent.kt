package com.study.core.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackBar(val messagexd: UiText): UiEvent()
}
