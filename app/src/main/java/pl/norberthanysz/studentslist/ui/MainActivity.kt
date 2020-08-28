package pl.norberthanysz.studentslist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pl.norberthanysz.studentslist.R
import pl.norberthanysz.studentslist.repository.ApiAdapter

class MainActivity : AppCompatActivity() {
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            getStudentsTest()
        }
    }

//todo delete after create students fragment
    private suspend fun getStudentsTest() {
        val response = ApiAdapter.apiClient.getStudents()

        response.body()?.let {students ->
            students.size
        }
    }
}