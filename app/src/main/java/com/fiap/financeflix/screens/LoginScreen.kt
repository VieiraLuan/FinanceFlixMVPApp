package com.fiap.financeflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiap.financeflix.R
import com.fiap.financeflix.utils.getGradientBackground


@Composable
fun LoginScreen() {

//	Screen
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(getGradientBackground()),
	) {


		//Header

		Column(

			horizontalAlignment = Alignment.Start,
			modifier = Modifier
				.fillMaxWidth()
				.height(250.dp)
				.padding(horizontal = 50.dp),

			verticalArrangement = Arrangement.Center,

			) {
			Text(
				color = colorResource(id = R.color.white),
				fontSize = 50.sp,
				fontWeight = FontWeight.Medium,
				textAlign = TextAlign.Start,
				text = stringResource(id = R.string.btn_loginScreen)
			)

			Spacer(modifier = Modifier.padding(top = 10.dp))

		}

		//Form
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 50.dp)
		) {

			//Componentizar os outlinedTextField
			OutlinedTextField(
				value = "",
				onValueChange = {

				},
				modifier = Modifier.fillMaxWidth(),
				placeholder = {
					Text(
						text = "Informe sua altura em cm",
						color = Color.White
					)
				},
				colors = OutlinedTextFieldDefaults.colors(
					unfocusedBorderColor = colorResource(id = R.color.white),
					focusedBorderColor = colorResource(id = R.color.white)
				),
				shape = RoundedCornerShape(16.dp),
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
			)

			Spacer(modifier = Modifier.padding(20.dp))

			OutlinedTextField(
				value = "",
				onValueChange = {

				},
				modifier = Modifier.fillMaxWidth(),
				placeholder = {
					Text(
						text = "Informe sua altura em cm",
						color = Color.White
					)
				},
				colors = OutlinedTextFieldDefaults.colors(
					unfocusedBorderColor = colorResource(id = R.color.white),
					focusedBorderColor = colorResource(id = R.color.white),

					),
				shape = RoundedCornerShape(16.dp),
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
			)

			Spacer(modifier = Modifier.padding(5.dp))

			Column(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
			) {
				Text(
					color = colorResource(id = R.color.white),
					fontSize = 20.sp,
					fontWeight = FontWeight.Medium,
					textAlign = TextAlign.Center,
					text = stringResource(id = R.string.text_forgot_password)
				)
			}

			Spacer(modifier = Modifier.padding(50.dp))

			Column(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center

			) {

				Button(
					onClick = {
//					navController.navigate("login")
					},
					modifier = Modifier.fillMaxWidth(),
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
				Spacer(modifier = Modifier.padding(5.dp))

				Text(
					color = colorResource(id = R.color.white),
					fontSize = 20.sp,
					fontWeight = FontWeight.Medium,
					textAlign = TextAlign.Center,
					text = stringResource(id = R.string.text_register_now)
				)


			}


		}


	}


//	Box(
//		modifier = Modifier
//			.fillMaxSize()
//			.background(getGradientBackground())
//	) {
//
//
//		Card(
//			modifier = Modifier
//				.fillMaxSize()
//				.background(getGradientBackground())
//		) {
//
//			Column(
//
//				horizontalAlignment = Alignment.Start,
//				verticalArrangement = Arrangement.Center
//			) {
//
//				Text(
//					color = colorResource(id = R.color.white),
//					fontSize = 50.sp,
//					fontWeight = FontWeight.Medium,
//					textAlign = TextAlign.Center,
//					text = stringResource(id = R.string.btn_loginScreen)
//				)
//
//
//				Spacer(modifier = Modifier.padding(20.dp))
//
//				OutlinedTextField(
//					value = "",
//					onValueChange = {
//
//					},
//					modifier = Modifier.fillMaxWidth(),
//					placeholder = {
//						Text(text = "Informe sua altura em cm")
//					},
//					colors = OutlinedTextFieldDefaults.colors(
//						unfocusedBorderColor = colorResource(id = R.color.background_color),
//						focusedBorderColor = colorResource(id = R.color.background_color)
//					),
//					shape = RoundedCornerShape(16.dp),
//					keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
//				)
//			}
//
//		}
//
//
//	}

	var emailState by remember { mutableStateOf("") }
	var passwordState by remember { mutableStateOf("") }

	//Implementar a tela de login utilizando ás variaveis de estado acima, acionando API


}


@Preview
@Composable
fun LoginScreenPreview() {
	LoginScreen()
}