package com.fiap.financeflix.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fiap.financeflix.components.CourseCard
import com.fiap.financeflix.components.SearchCard


@Composable
fun HomeScreen() {

	var courseNameState by remember { mutableStateOf("") }

	//Titulo

	//Implementar card
	SearchCard()

	//LazyColumn
	//Entender course category card

		//LazyList
	CourseCard()

}