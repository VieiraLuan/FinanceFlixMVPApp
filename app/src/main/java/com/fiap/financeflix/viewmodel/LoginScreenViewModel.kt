package com.fiap.financeflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fiap.financeflix.model.Login
import com.fiap.financeflix.service.AuthService
import com.fiap.financeflix.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginScreenViewModel() : ViewModel() {

//	Mutables and Observables

	private val _email = MutableLiveData<String>()

	val email: LiveData<String> = _email

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

	fun login(email: String, password: String, callback: (Boolean) -> Unit) {

		val userCredentials = Login(email, password)

		try {
			val call = RetrofitFactory().getAuthService().postLogin(userCredentials)

			call.enqueue(object : Callback<Login> {
				override fun onResponse(call: Call<Login>, response: Response<Login>) {
					if (response.isSuccessful) {
						Log.e("API_FF", response.message())
						callback(true)
					} else {
						Log.e("API_FF", response.message())
						callback(false)
					}
				}

				override fun onFailure(call: Call<Login>, t: Throwable) {
					Log.e("API_FF", "${t.message}")
					callback(false)
				}
			})

		} catch (e: Exception) {
			e.printStackTrace()
			Log.e("API ERRO", "${e.message}")
			callback(false)
		}
	}


}