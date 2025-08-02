package com.example.ar_xeta_intership.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ar_xeta_intership.navigation.ARScreen
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import kotlin.random.Random

@Composable
fun ModelScreen(navController: NavController) {
    val listOfModels = listOf(
        "Cube", "Sphere", "Cylinder", "Cone", "Torus",
        "Pyramid", "Suzanne", "Plane", "Capsule", "Icosahedron"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Models",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        FlowColumn {
            listOfModels.forEach { model ->
                ModelItem(model = model) {
                    navController.navigate(ARScreen(model))
                }
            }
        }
    }
}

@Composable
fun ModelItem(model: String, onClick: () -> Unit) {
    val color = remember(model) {
        generateRandomLightColor()
    }

    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = model,
            fontSize = 16.sp
        )
    }
}

fun generateRandomLightColor(): Color {
    val random = Random(System.currentTimeMillis())
    val red = random.nextInt(150, 256)
    val green = random.nextInt(200, 256)
    val blue = random.nextInt(200, 256)
    return Color(red, green, blue)
}
