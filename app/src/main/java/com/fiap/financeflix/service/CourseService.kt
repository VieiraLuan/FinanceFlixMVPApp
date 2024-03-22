package com.fiap.financeflix.service

import com.fiap.financeflix.model.Course
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CourseService {


//	fun getCourseById()

	//	BASEURL/api/v1/Curso/GetAll
	@GET("api/v1/Curso/GetAll")
	fun getAllCoursesWithCategories(): Call<List<Course>>


}