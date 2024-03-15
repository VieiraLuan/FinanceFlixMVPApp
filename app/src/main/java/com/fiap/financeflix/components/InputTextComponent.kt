package com.fiap.financeflix.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fiap.financeflix.R

@Composable
fun InputTextComponent(
	value: String,
	label: String,
	placeholder: String,
	keyboardType: KeyboardType,
	updateValue: (String) -> Unit,
	validation: Boolean,
	messageValidation: String,
	passwordField: Boolean,

	) {

	val visualTransformation = if (passwordField) {
		PasswordVisualTransformation()
	} else {
		VisualTransformation.None
	}

	OutlinedTextField(
		modifier = Modifier.fillMaxWidth(),
		shape = RoundedCornerShape(16.dp),
		keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
		textStyle = TextStyle(colorResource(id = R.color.white)),
		label = { Text(text = label, color = colorResource(id = R.color.white)) },
		placeholder = { Text(text = placeholder, color = colorResource(id = R.color.white)) },
		value = value,
		onValueChange = updateValue,
		isError = validation,
		visualTransformation = visualTransformation
	)
	if (validation) {
		Text(
			text = messageValidation,
			color = Color.Red
		)
	}


}