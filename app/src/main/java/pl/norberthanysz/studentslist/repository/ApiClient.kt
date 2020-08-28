package pl.norberthanysz.studentslist.repository

import pl.norberthanysz.studentslist.models.StudentModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/v2/5db2e026350000a91af5527c")
    suspend fun getStudents(): Response<List<StudentModel>>
}