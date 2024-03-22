package com.fiap.financeflix.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import androidx.navigation.NavController
import com.fiap.financeflix.R
import com.fiap.financeflix.components.CourseCard
import com.fiap.financeflix.components.SearchCard
import com.fiap.financeflix.model.Course
import com.fiap.financeflix.utils.getGradientBackground
import com.fiap.financeflix.viewmodel.HomeScreenViewModel


@SuppressLint("MutableCollectionMutableState")
@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel,navController: NavController) {


	var course by remember {
		mutableStateOf("")
	}

	var courseListState: List<Course> by remember {
		mutableStateOf(emptyList())
	}

//	LaunchedEffect(Unit) {
//
//	}

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

			SearchCard(
				course,
				"Clique na lupa, em seguida digite alguma coisa....",
				{
					courseListState = homeScreenViewModel.getCourseWithCategories()
				}, {
					homeScreenViewModel.searchAll()

				}
			)

			Spacer(modifier = Modifier.padding(10.dp))

		}

		LazyColumn(
			modifier = Modifier
				.padding(horizontal = 20.dp, vertical = 10.dp)
		) {
			items(courseListState.count()) {
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween
				) {
					Text(
						modifier = Modifier.padding(8.dp),
						color = colorResource(id = R.color.white),
						fontSize = 20.sp,
						fontWeight = FontWeight.Medium,
						textAlign = TextAlign.Center,
						text = courseListState[it].category.name
					)

				}

				Row(

				) {
					LazyRow {
						items(courseListState.count()) {
							CourseCard(courseListState[it].name, navController)
							Spacer(modifier = Modifier.padding(10.dp))
						}
					}
				}
			}
		}


	}


}


