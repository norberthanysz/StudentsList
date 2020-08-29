package pl.norberthanysz.studentslist.ui.students

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.norberthanysz.studentslist.R
import pl.norberthanysz.studentslist.models.StudentModel
import java.util.*

class StudentsListAdapter(
    private val studentsList: List<StudentModel>,
) : RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.student_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.name.text = studentsList[position].name
        holder.age.text = getAge(studentsList[position].yearOfBirth).toString() + " yo"
        if (studentsList[position].status) {
            holder.status.setTextColor(holder.status.context.resources.getColor(R.color.status_ok))
            holder.status.text = holder.status.context.getString(R.string.status_ok)
        } else {
            holder.status.setTextColor(holder.status.context.resources.getColor(R.color.status_not_ok))
            holder.status.text = holder.status.context.getString(R.string.status_not_ok)
        }
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    private fun getAge(yearOfBirth: Int): Int {
        val actualYear = Calendar.getInstance().get(Calendar.YEAR);
        return actualYear - yearOfBirth
    }
}