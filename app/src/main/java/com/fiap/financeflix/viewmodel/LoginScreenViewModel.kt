package com.fiap.financeflix.viewmodel


import TokenManager
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fiap.financeflix.model.Login
import com.fiap.financeflix.model.LoginResult
import com.fiap.financeflix.service.RetrofitFactory
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginScreenViewModel(private val context: Context) : ViewModel() {

//	Mutables and Observables

	private val _email = MutableLiveData<String>()

	var email: LiveData<String> = _email

	private val _password = MutableLiveData<String>()

	val password: LiveData<String> = _password

//	Getting Values

	//Obtendo valores
	fun onEmailChanged(email: String) {
		_email.value = email
	}

	fun onPasswordChanged(password: String) {
		_password.value = password
	}

	//	Methods

	fun login(email: String, password: String, callback: (LoginResult) -> Unit) {

		val userCredentials = Login(email, password)
		Log.i("Dados", "$email e $password")

		Thread {

			val body = Gson().toJson(userCredentials)
				.toRequestBody("application/json; charset=UTF-8".toMediaType())
			//Contexto
			RetrofitFactory(context).getAuthService().postLogin(body)
				.enqueue(object : Callback<ResponseBody> {
					override fun onResponse(
						call: Call<ResponseBody>,
						response: Response<ResponseBody>,
					) {

						if (response.isSuccessful) {

							val message = response.body()?.string()
							val gson = Gson()
							val jsonObject = gson.fromJson(message, JsonObject::class.java)
							val token = jsonObject.get("token").asString

							// Salvar o token usando TokenManager
							val tokenManager = TokenManager(context)
							tokenManager.saveToken(token)

							callback(LoginResult(true, message ?: ""))

							Log.i("API_SUCESS", message ?: "Response Body is Null")
							tokenManager.getToken()?.let { Log.i("TOKEN_SAVED", it) }


						} else {

							val message = response.errorBody()?.string()

							callback(LoginResult(false, message ?: ""))

							Log.i("API_WARNING", message ?: "Error body is null")

						}


					}

					override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
						val message = "Serviço indisponível no momento"
						Log.e("API_ERROR", message ?: "Error body is null")
						callback(LoginResult(false, message ?: ""))
					}

				})

		}.start()

	}

}