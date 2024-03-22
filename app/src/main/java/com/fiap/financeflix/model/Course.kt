package com.fiap.financeflix.model

import com.google.gson.annotations.SerializedName

data class Course(


	@SerializedName("id") val id: String,
	@SerializedName("nome") val name: String,
	@SerializedName("descricao") val description: String,
	@SerializedName("imagem") val image: String?,
	@SerializedName("categoria") val category: Category

)
