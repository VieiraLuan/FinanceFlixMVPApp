package com.fiap.financeflix.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.fiap.financeflix.R

@Composable
fun SearchCard(
	value: String,
	label: String,
	updateValue: (String) -> Unit,
	onClick: () -> Unit,
) {

	OutlinedTextField(
		modifier = Modifier.fillMaxWidth(),
		shape = RoundedCornerShape(16.dp),
		label = { Text(text = label, color = colorResource(id = R.color.white)) },
		value = value,
		onValueChange = updateValue,
		trailingIcon = {
			IconButton(
				onClick = onClick
			) {
				Icon(
					Icons.Default.Search,
					contentDescription = "Search Image",
					tint = colorResource(id = R.color.white)
				)
			}
		},
		textStyle = TextStyle(colorResource(id = R.color.white))
	)

}