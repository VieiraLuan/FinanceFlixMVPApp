package com.fiap.financeflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.fiap.financeflix.R
import com.fiap.financeflix.utils.getGradientBackground


@Composable
fun VideoPlayerScreen() {



		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
					modifier = Modifier.background(getGradientBackground()).fillMaxSize()

			) {
			Text(
				text = "Em breve player de video",
				textAlign = TextAlign.Center,
				color = Color.White,
				fontSize = 50.sp
			)
		}


}


@Preview
@Composable
fun VideoPlayerScreenPreview() {
	VideoPlayerScreen()
}

