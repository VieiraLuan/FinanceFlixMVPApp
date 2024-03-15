package com.fiap.financeflix.service

import androidx.compose.ui.res.stringResource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

	private val baseUrlDev: String = "https://financeflix-dev.azurewebsites.net/api/"
//	private val baseUrl: String = "https://financeflix.azurewebsites.net/api/"

	private val retrofitFactory =
		Retrofit.Builder().baseUrl(baseUrlDev).addConverterFactory(GsonConverterFactory.create())
			.build()


	// LoginScreen

	fun getAuthService(): AuthService {
		return retrofitFactory.create(AuthService::class.java)
	}

	// HomeScreen and VideoDetailScreen


	fun getCategoryService(): CategoryService {
		return retrofitFactory.create(CategoryService::class.java)
	}


	fun getCourseService(): CourseService {
		return retrofitFactory.create(CourseService::class.java)
	}


	//VideoPlayer as well
	fun getVideoService(): VideoService {
		return retrofitFactory.create(VideoService::class.java)
	}


}