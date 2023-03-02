package com.study.tracker.navigation

import androidx.navigation.NavController
import com.study.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}