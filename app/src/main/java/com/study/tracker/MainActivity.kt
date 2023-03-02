package com.study.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.core.navigation.Route
import com.study.onboarding_presentation.age.AgeScreen
import com.study.onboarding_presentation.gender.GenderScreen
import com.study.onboarding_presentation.welcome.WelcomeScreen
import com.study.tracker.navigation.navigate
import com.study.tracker.ui.theme.CaloryTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Route.WELCOME
                        ) {
                            composable(Route.WELCOME){
                                WelcomeScreen(onNavigate = navController::navigate)
                            }
                            composable(Route.AGE){
                                AgeScreen(
                                    scaffoldState = scaffoldState,
                                    onNavigate = navController::navigate
                                )
                            }
                            composable(Route.GENDER){
                                GenderScreen(onNavigate = navController::navigate)
                            }
                            composable(Route.HEIGHT){

                            }
                            composable(Route.WEIGHT){

                            }
                            composable(Route.NUTRIENT_GOAL){

                            }
                            composable(Route.ACTIVITY){

                            }
                            composable(Route.GOAL){

                            }
                            composable(Route.TRACKER_OVERVIEW){

                            }
                            composable(Route.SEARCH){

                            }
                        }
                    }

                }
            }
        }
    }
}

