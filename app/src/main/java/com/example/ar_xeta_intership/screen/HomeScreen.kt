package com.example.ar_xeta_intership.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.ar_xeta_intership.component.RetroBtn


@Composable
fun HomeScreen(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Hello")
        RetroBtn(title = "Play",
            route = ModelScreen(navController),
            navController = navController)
//        RetroBtn(title = "Setting", route = ProfileScreen(), navController = navController )
//        RetroBtn(title = "Exit", route = Unit, navController = navController)
    }

}