package com.example.mos_parking

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.example.mos_parking.ui.HomeScreen
import com.example.mos_parking.ui.ListScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(){
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route,
            exitTransition = {
                slideOutHorizontally (
                    targetOffsetX = {-300},
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                    )+
                fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally (
                    initialOffsetX = {300},
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                )+ fadeIn(animationSpec = tween(300))
            }){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.ListScreen.route,
            exitTransition = {
                slideOutHorizontally (
                    targetOffsetX = {-300},
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                )+
                        fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally (
                    initialOffsetX = {300},
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                )+ fadeIn(animationSpec = tween(300))
            }
        ){
            entry->
            ListScreen(navController = navController)
        }
    }
}