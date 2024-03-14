package com.fiap.financeflix.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.fiap.financeflix.components.WelcomeCard

@Composable
fun InitialScreen(
	navController: NavController,

	) {
	WelcomeCard(navController)
}