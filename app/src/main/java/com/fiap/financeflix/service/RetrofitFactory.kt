package com.fiap.financeflix.service

import android.content.Context
import androidx.compose.ui.res.stringResource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitFactory {

	
	val baseUrl: String = "https://financeflix-dev.azurewebsites.net/"
//	private val baseUrl: String = "https://financeflix.azurewebsites.net/api/"

	fun client() = OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
		.readTimeout(30, TimeUnit.SECONDS)
		.addInterceptor(HttpLoggingInterceptor().apply {
			level = HttpLoggingInterceptor.Level.BODY
		}).build()

	fun gson(): Gson = GsonBuilder().create()


	private val retrofitFactory =
		Retrofit.Builder().baseUrl(baseUrl).client(client())
			.addConverterFactory(GsonConverterFactory.create(gson()))
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