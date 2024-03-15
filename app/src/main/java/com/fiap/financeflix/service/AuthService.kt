package com.fiap.financeflix.service

import android.util.Log
import com.fiap.financeflix.model.Login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {


	//	Route -> v1/Usuario/Login
	@POST("v1/Usuario/Login")
	fun postLogin(@Body requestBody: Login): Call<Login>


	fun postCreateAccount()

}