package com.fiap.financeflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.financeflix.R
import com.fiap.financeflix.components.CourseCard
import com.fiap.financeflix.components.SearchCard
import com.fiap.financeflix.utils.getGradientBackground
import com.fiap.financeflix.viewmodel.HomeScreenViewModel


@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel) {

	//Observers
	val course by homeScreenViewModel.course.observeAsState(initial = "")


	//Screen
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(getGradientBackground())
			.padding(horizontal = 0.dp, vertical = 20.dp),
		horizontalAlignment = Alignment.CenterHorizontally,


		) {
		Text(
			color = colorResource(id = R.color.white),
			fontSize = 30.sp,
			fontWeight = FontWeight.Medium,
			textAlign = TextAlign.Center,
			text = stringResource(id = R.string.text_main)
		)

		Column(
			modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
		) {
			//Implementar card
			SearchCard(
				course,
				stringResource(id = R.string.text_find_courses),
				{
					homeScreenViewModel.onCourseChanged(it)
				},
				{

				}
			)

		}


	}


	//LazyColumn
	//Entender course category card

	//LazyList
	CourseCard()

}


@Preview
@Composable
fun HomeScreenPreview() {
	HomeScreen(homeScreenViewModel = HomeScreenViewModel())
}