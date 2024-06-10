package com.fiap.financeflix.service

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {



	@POST("api/v1/Usuario/login")
	fun postLogin(@Body requestBody: RequestBody): Call<ResponseBody>


	fun postCreateAccount()

}