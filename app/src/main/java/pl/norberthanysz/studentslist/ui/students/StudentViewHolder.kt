package pl.norberthanysz.studentslist.ui.students

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_item.view.*

class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.name
    val age: TextView = view.age
    val status: TextView = view.status
}