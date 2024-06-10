package com.fiap.financeflix.service

import TokenManager
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitFactory(private val context: Context) {

	private val tokenManager = TokenManager(context)

	val baseUrl: String = "https://financeflix-dsv.azurewebsites.net/"


	private fun client(): OkHttpClient {
		val interceptor = HttpLoggingInterceptor().apply {
			level = HttpLoggingInterceptor.Level.BODY
		}

		return OkHttpClient.Builder()
			.connectTimeout(120, TimeUnit.SECONDS)
			.readTimeout(120, TimeUnit.SECONDS)
			.addInterceptor(interceptor)
			.addInterceptor { chain ->
				val original = chain.request()
				val requestBuilder = original.newBuilder()
					.header("Authorization", "Bearer ${tokenManager.getToken()}")
				val request = requestBuilder.build()
				chain.proceed(request)
			}
			.build()
	}

	fun gson(): Gson = GsonBuilder().create()


	private val retrofitFactory =
		Retrofit.Builder().baseUrl(baseUrl).client(client())
			.addConverterFactory(GsonConverterFactory.create())
			.build()


	// LoginScreen

	fun getAuthService(): AuthService {
		return retrofitFactory.create(AuthService::class.java)
	}

	// HomeScreen


	fun getCourseService(): CourseService {
		return retrofitFactory.create(CourseService::class.java)
	}





}