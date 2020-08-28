package pl.norberthanysz.studentslist.ui.students

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.norberthanysz.studentslist.models.UIState

class StudentsListViewModel: ViewModel() {

    var uiState: MutableLiveData<UIState> = MutableLiveData(UIState.Initialized)

}