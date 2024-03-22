package com.fiap.financeflix.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiap.financeflix.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseCard(
	courseName: String,
	navController:NavController
) {
	Card(
		elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
		colors = CardDefaults.cardColors(Color.Black),
		onClick = { Log.i("Click", "clicando")
			navController.navigate("player")
		}
	) {
		Column(
			modifier = Modifier
				.width(300.dp)
				.height(500.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,

			) {
			Image(
				painter = painterResource(id = R.drawable.logo_ff),
				contentDescription = "Finance-Flix-Logo"
			)
		}
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
		) {
			Text(

				text = courseName, color = Color.White, textAlign = TextAlign.Center
			)
		}
	}
}