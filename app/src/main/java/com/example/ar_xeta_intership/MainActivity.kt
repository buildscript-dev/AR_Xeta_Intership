package com.example.ar_xeta_intership

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ar_xeta_intership.navigation.ARScreen
import com.example.ar_xeta_intership.navigation.HomeScreen
import com.example.ar_xeta_intership.navigation.ModelScreen
import com.example.ar_xeta_intership.navigation.ProfileScreen
import com.example.ar_xeta_intership.screen.ARScreen
import com.example.ar_xeta_intership.screen.HomeScreen
import com.example.ar_xeta_intership.screen.ModelScreen
import com.example.ar_xeta_intership.screen.ProfileScreen
import com.example.ar_xeta_intership.ui.theme.AR_Xeta_IntershipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AR_Xeta_IntershipTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = HomeScreen){
                    composable<HomeScreen>{
                        HomeScreen(navController)
                    }
                    composable<ARScreen> {
                        val task = it.toRoute<ARScreen>().model
                        ARScreen(navController, task)
                    }
                    composable<ModelScreen> {
                        ModelScreen(navController)
                    }
                }
            }
        }
    }
}