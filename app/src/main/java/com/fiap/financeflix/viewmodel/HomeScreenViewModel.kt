package com.fiap.financeflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HomeScreenViewModel {

	private val _course = MutableLiveData<String>()

	val course: LiveData<String> = _course

	fun onCourseChanged(course: String) {
		_course.value = course
	}


}
