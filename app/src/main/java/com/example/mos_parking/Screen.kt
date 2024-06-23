package com.example.mos_parking

sealed class Screen(val route: String){
    object HomeScreen: Screen("home_screen")
    object ListScreen: Screen("list_screen")
}