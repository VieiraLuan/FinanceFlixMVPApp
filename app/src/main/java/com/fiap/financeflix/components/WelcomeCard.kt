package com.fiap.financeflix.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiap.financeflix.R
import com.fiap.financeflix.utils.getGradientBackground

@Composable
fun WelcomeCard(navController: NavController) {


	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(getGradientBackground())

	) {

		Column(
			modifier = Modifier.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {

			Image(
				painter = painterResource(id = R.drawable.logo_ff1000),
				contentDescription = "Finance-Flix",
				modifier = Modifier
					.clip(shape = CircleShape)

			)

			Text(
				color = colorResource(id = R.color.white),
				fontSize = 50.sp,
				fontWeight = FontWeight.Medium,
				textAlign = TextAlign.Center,
				text = stringResource(id = R.string.app_title)
			)

			Spacer(modifier = Modifier.padding(20.dp))

			Text(
				color = colorResource(id = R.color.white),
				fontSize = 20.sp,
				fontWeight = FontWeight.Medium,
				textAlign = TextAlign.Center,
				text = stringResource(id = R.string.app_slogan)
			)

			Spacer(modifier = Modifier.padding(20.dp))

			Box(
				modifier = Modifier
					.width(200.dp)
					.height(48.dp)
					.border(
						5.dp,
						colorResource(id = R.color.background_color),
						RoundedCornerShape(16.dp)
					)
			) {
				Button(
					onClick = {
						navController.navigate("login")
					},
					modifier = Modifier.fillMaxSize(),
					shape = RoundedCornerShape(30.dp),
					colors = ButtonDefaults.buttonColors(Color(R.color.black)),

					) {
					Text(
						text = stringResource(id = R.string.btn_login),
						fontWeight = FontWeight.Bold,
						color = Color.White,
						fontSize = 14.sp
					)
				}
			}


		}


	}

}


