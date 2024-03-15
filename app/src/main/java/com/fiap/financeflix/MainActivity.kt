package com.fiap.financeflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fiap.financeflix.screens.HomeScreen
import com.fiap.financeflix.screens.InitialScreen
import com.fiap.financeflix.screens.LoginScreen
import com.fiap.financeflix.screens.VideoDetailScren
import com.fiap.financeflix.service.AuthService
import com.fiap.financeflix.ui.theme.FinanceFlixTheme
import com.fiap.financeflix.viewmodel.LoginScreenViewModel

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			FinanceFlixTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					//Routes
					val navController = rememberNavController()

					//Main Route
					NavHost(navController = navController, startDestination = "initial")
					{

						composable(route = "initial") { InitialScreen(navController) }
						composable(route = "login") { LoginScreen(loginScreenViewModel = LoginScreenViewModel(), navController) }
						composable(route = "home") { HomeScreen() }
						composable(route = "videoDetails") { VideoDetailScren() }
						composable(route = "player") { VideoDetailScren() }

					}


				}
			}
		}
	}
}



