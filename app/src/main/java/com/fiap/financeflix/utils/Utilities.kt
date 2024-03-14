package com.fiap.financeflix.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import com.fiap.financeflix.R

@Composable
fun getGradientBackground(): Brush {
	val startColor = colorResource(id = R.color.gradient_start)
	val endColor = colorResource(id = R.color.gradient_end)

	return Brush.verticalGradient(
		colors = listOf(startColor, endColor),
		startY = 0f,
		endY = Float.POSITIVE_INFINITY
	)
}


