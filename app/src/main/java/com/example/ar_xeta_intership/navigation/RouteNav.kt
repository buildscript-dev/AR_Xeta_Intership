package com.example.ar_xeta_intership.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
object HomeScreen

@Serializable
data class ARScreen(val model: String)

@Serializable
object ModelScreen

@Serializable
object ProfileScreen