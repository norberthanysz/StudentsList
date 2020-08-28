package pl.norberthanysz.studentslist.ui.students

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pl.norberthanysz.studentslist.models.StudentModel
import pl.norberthanysz.studentslist.models.UIState
import pl.norberthanysz.studentslist.repository.StudentsRepository

class StudentsListViewModel : ViewModel() {

    var uiState: MutableLiveData<UIState> = MutableLiveData(UIState.Initialized)
    var studentsList: List<StudentModel> = ArrayList()
    var studentsRepository: StudentsRepository = StudentsRepository()

    @ExperimentalCoroutinesApi
    suspend fun getStudentsList() {
        uiState.postValue(UIState.InProgress)
        studentsRepository.getStudents().let {
            if (it != null) {
                studentsList = it
                uiState.postValue(UIState.ShowError)
            } else {
                uiState.postValue(UIState.ShowError)
            }
        }
    }

    fun getPreparedList(): List<StudentModel> {
        return studentsList.distinctBy { listOf<Any>(it.name, it.yearOfBirth, it.status) }
    }
}