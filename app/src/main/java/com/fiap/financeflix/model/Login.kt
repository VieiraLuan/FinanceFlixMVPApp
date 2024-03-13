package com.fiap.financeflix.model

import com.google.gson.annotations.SerializedName

data class Login(


	@SerializedName("email") var email: String = "",
	@SerializedName("senha") var password: String = "",


	//	Json Signature
	//{
	//	"email": "string",
	//	"senha": "string"
	//}


)
