package pl.norberthanysz.studentslist.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import pl.norberthanysz.studentslist.models.StudentModel

class StudentsRepository @ExperimentalCoroutinesApi constructor() {

    @ExperimentalCoroutinesApi
    suspend fun getStudents(): List<StudentModel>? {
        val response = ApiAdapter.apiClient.getStudents()
        response.body()?.let { students ->
            return students
        } ?: return null
    }

}