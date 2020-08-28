package pl.norberthanysz.studentslist.models

sealed class UIState {
    object Initialized : UIState()
    object InProgress : UIState()
    object NotInProgress : UIState()
    object ShowList : UIState()
    object ShowError : UIState()

}