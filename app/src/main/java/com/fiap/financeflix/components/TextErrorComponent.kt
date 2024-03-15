package com.fiap.financeflix.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextErrorComponent(
	messageError: String,
) {

	Text(
		color = Color.Red,
		fontSize = 20.sp,
		fontWeight = FontWeight.Medium,
		textAlign = TextAlign.Start,
		text = messageError
	)

}