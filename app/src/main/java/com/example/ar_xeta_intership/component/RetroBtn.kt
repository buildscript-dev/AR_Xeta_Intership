package com.example.ar_xeta_intership.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RetroBtn(
    title: String,
    route: Unit,
    navController: NavController
) {
    Button(
        onClick = { navController.navigate(route) }
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
