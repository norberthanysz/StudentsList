package pl.norberthanysz.studentslist.models

import com.google.gson.annotations.SerializedName

data class StudentModel(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("year_of_birth")
    val yearOfBirth: Int = 0,
    @SerializedName("student")
    val status: Boolean = true
)