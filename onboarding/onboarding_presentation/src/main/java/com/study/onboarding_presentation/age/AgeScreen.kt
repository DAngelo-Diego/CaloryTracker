package com.study.onboarding_presentation.age

import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.study.core.R
import com.study.core.util.UiEvent
import com.study.core_ui.LocalSpacing
import com.study.onboarding_presentation.components.ActionButton
import com.study.onboarding_presentation.components.UnitTextField
import kotlinx.coroutines.flow.collect

@Composable
fun AgeScreen(
  scaffoldState: ScaffoldState,
  viewModel: AgeScreenViewModel = hiltViewModel(),
  onNextClick: () -> Unit
) {
  val context = LocalContext.current
  val spacing = LocalSpacing.current
  LaunchedEffect(key1 = true) {
    viewModel.uiEvent.collect { event ->
      when(event) {
        is UiEvent.Success -> onNextClick()
        is UiEvent.ShowSnackBar -> {
          scaffoldState.snackbarHostState.showSnackbar(
            //here we unwrapped the UiText
            message = event.messagexd.asString(context)
          )
        }
        else -> Unit
      }
    }
  }
  Box(modifier = Modifier
    .fillMaxSize()
    .padding(spacing.spaceLarge)
  ){
    Column(modifier = Modifier
      .fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = stringResource(id = R.string.whats_your_age)
      )
      Spacer(modifier = Modifier.height(spacing.spaceMedium))
     UnitTextField(
       value = viewModel.age,
       onValueChange = viewModel::onAgeEnter,
       unit = stringResource(id = R.string.years)
     )
    }
    ActionButton(
      text = stringResource(id = R.string.next),
      onClick =  viewModel::onNextClick,
      modifier= Modifier.align(Alignment.BottomEnd)
    )
  }
}
