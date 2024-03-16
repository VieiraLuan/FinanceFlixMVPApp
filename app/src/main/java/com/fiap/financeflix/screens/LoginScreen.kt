package com.fiap.financeflix.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiap.financeflix.R
import com.fiap.financeflix.components.InputTextComponent
import com.fiap.financeflix.components.TextErrorComponent
import com.fiap.financeflix.model.LoginResult
import com.fiap.financeflix.utils.getGradientBackground
import com.fiap.financeflix.viewmodel.LoginScreenViewModel
import com.google.gson.JsonParser


@Composable
fun LoginScreen(loginScreenViewModel: LoginScreenViewModel, navController: NavController) {


	//Observers
	val emailState by loginScreenViewModel.email.observeAsState(initial = "")
	val passwordState by loginScreenViewModel.password.observeAsState(initial = "")

	//Validation
	var emailError by remember { mutableStateOf(false) }
	var passwordError by remember { mutableStateOf(false) }
	var loginError by remember { mutableStateOf(false) }


	//Validation Message

	var emailMessageError by remember { mutableStateOf("") }
	var passwordMessageError by remember { mutableStateOf("") }
	var loginMessageError by remember { mutableStateOf("") }
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


			InputTextComponent(
				value = emailState,
				label = stringResource(id = R.string.text_label_email),
				placeholder = stringResource(id = R.string.text_placeholder_email),
				keyboardType = KeyboardType.Email,
				updateValue = {
					loginScreenViewModel.onEmailChanged(it)
				},
				validation = emailError,
				messageValidation = emailMessageError,
				passwordField = false
			)

			Spacer(modifier = Modifier.padding(20.dp))

			InputTextComponent(
				value = passwordState,
				label = stringResource(id = R.string.text_label_password),
				placeholder = stringResource(id = R.string.text_placeholder_email),
				keyboardType = KeyboardType.Password,
				updateValue = {
					loginScreenViewModel.onPasswordChanged(it)
				},
				validation = passwordError,
				messageValidation = passwordMessageError,
				passwordField = true

			)

			if (loginError) {
				TextErrorComponent(messageError = loginMessageError)
			}

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
						try {
							if (emailState.isNotEmpty() && passwordState.isNotEmpty()) {
								loginScreenViewModel.login(
									emailState,
									passwordState
								) { loginSuccess ->
									if (loginSuccess.success) {

										navController.navigate("home")


									} else {
										loginError = true


										loginMessageError = "Usuário ou senha inválidos"
									}
								}
							} else {
								if (emailState.isEmpty()) {
									emailError = true
								}
								if (passwordState.isEmpty()) {
									passwordError = true
								}
							}

						} catch (e: Exception) {
							Log.e("ERRO NA TELA LOGIN", "${e.message}")
						}

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
}

