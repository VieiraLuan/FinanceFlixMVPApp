package com.fiap.financeflix.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiap.financeflix.model.Category
import com.fiap.financeflix.model.Course
import com.fiap.financeflix.service.RetrofitFactory
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreenViewModel(private val context: Context) :
	ViewModel() {

	private var _courseListWithCategories = MutableLiveData<List<Course>>()


	var courseList = mutableListOf<Course>()

	fun getCourseWithCategories(): List<Course> {

		Log.i("VM_TO_SCREEN", courseList.toString())
		return courseList
	}

	//Lista criada para testes e caso a API na Azure fique fora do Ar,
	// estamos enfrentando instabilidade nos serviços MS
	fun mockCourseList(list:List<Course>) {

		if(list.isEmpty()) {

			Log.i("API", "LISTA MOCKADA")

			val courseListMock = listOf(
				Course(
					id = "84cde7e9-8e36-4ddc-bc66-b88811f496ed",
					name = "Investindo em LCI e LCA",
					description = "Maximize rendimentos com segurança.",
					image = "",
					category = Category(
						id = "8e3f611e-9b31-4d53-a5e6-12e04d599a54",
						name = "Renda Fixa",
						description = "Desvende segredos da renda fixa. Aprenda estratégias para segurança financeira em nossos cursos especializados.",
						createdDate = "3/5/2024 12:04:50 AM"
					)
				),
				Course(
					id = "19af6b03-26ba-4c8f-8be4-a3adce297d65",
					name = "Crédito Imobiliário",
					description = "Conquiste seu lar com expertise em Crédito Imobiliário. Da base à negociação avançada, realizamos seu sonho.",
					image = "",
					category = Category(
						id = "bf062383-cea3-48bf-b3fb-b8f267f80372",
						name = "Crédito",
						description = "Explore finanças, empréstimos e gestão de crédito em nossa categoria especializada.",
						createdDate = "3/5/2024 12:03:11 AM"
					)
				),
				Course(
					id = "86252f1b-a54d-45a3-9f58-9085f248678e",
					name = "Empreendedorismo Visionário: Do Conceito à Concretização",
					description = "Explore o excitante mundo do Empreendedorismo em nossos cursos especializados.",
					image = "",
					category = Category(
						id = "b92b7bc7-8521-4d1c-90a0-03b09dca2bfc",
						name = "Empreendedorismo",
						description = "Explore a categoria Empreendedorismo e liberte seu potencial para criar, inovar e prosperar nos negócios.",
						createdDate = "3/5/2024 12:06:34 AM"
					)
				),
				Course(
					id = "559544b7-18b4-4b74-958e-026484dea45b",
					name = "Dominando os Mercados de Ações com Estratégias Eficientes",
					description = "Descubra o fascinante universo dos Mercados de Ações em nosso curso especializado",
					image = "",
					category = Category(
						id = "58c271d6-dad9-455c-b730-3f3605728372",
						name = "Mercado de Ações",
						description = "Explore nossa categoria de cursos de Mercado de Ações e mergulhe no mundo dinâmico dos investimentos.",
						createdDate = "3/5/2024 12:05:54 AM"
					)
				)
			)

			courseList = courseListMock.toMutableList()
		}else{
			Log.i("LIST_DATA",list.toString())
		}

	}

	fun searchAll() {
		Thread {
			try {
				Log.i("API_", "Finding All Courses with categories")

				val call =
					RetrofitFactory(context).getCourseService().getAllCoursesWithCategories()

				call.enqueue(object : Callback<List<Course>> {

					override fun onResponse(
						call: Call<List<Course>>,
						response: Response<List<Course>>,
					) {

						Log.i("API_", "API RESPONSE")

						if (response.code().toString() == "204") {

							Log.i("API_", "CODE: - ${response.code()}")

							mockCourseList(courseList)


						} else {

							Log.i("API_", "CODE: - ${response.code()}")


							if (response.isSuccessful) {
								Log.i("API_", "SUCESS")

								try {


//									courseList = response.body() as MutableList<Course>

									response.body()?.forEach {
//Implementar validação futuramente vazio ou nulo
										courseList.add(
											Course(
												it.id,
												it.name,
												it.description,
												it.image,
												it.category
											)
										)
									}

									mockCourseList(courseList)


								} catch (e: Exception) {
									Log.i("JSON_VALUE", "ERRO DE NULL OR EMPTY")
								}


							} else {
								Log.i("API_", "Falhou")
								Log.i(
									"API_WARNING",
									"BODY: ${response.body()} ERRORBODY:${
										response.errorBody().toString()
									} MESSAGE: ${response.message()}"
								)
							}

						}
					}

					override fun onFailure(call: Call<List<Course>>, t: Throwable) {
						Log.i("API_FAIL", "Falha ao acessar a API")
					}


				})

			} catch (e: Exception) {
				Log.i("API_", "Exception ${e.message}")
			}
		}.start()
	}

}
