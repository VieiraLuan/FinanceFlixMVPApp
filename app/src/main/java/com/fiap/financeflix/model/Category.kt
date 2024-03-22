package com.fiap.financeflix.model

import com.google.gson.annotations.SerializedName

data class Category(

	@SerializedName("id") val id: String,
	@SerializedName("nome") val name: String,
	@SerializedName("descricao") val description: String,
	@SerializedName("createdDate") val createdDate: String

)