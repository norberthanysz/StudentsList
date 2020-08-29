package pl.norberthanysz.studentslist.ui.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.students_list_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pl.norberthanysz.studentslist.R
import pl.norberthanysz.studentslist.databinding.StudentsListFragmentBinding
import pl.norberthanysz.studentslist.models.UIState

class StudentsListFragment : Fragment() {

    private lateinit var binding: StudentsListFragmentBinding
    private lateinit var viewModel: StudentsListViewModel

    lateinit var layoutManager: LinearLayoutManager
    lateinit var studentsListAdapter: StudentsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.students_list_fragment, container, false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this
        binding.view = this

        viewModel = ViewModelProvider(this).get(StudentsListViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.uiState.observe(viewLifecycleOwner, { uiState ->

            when (uiState) {
                is UIState.Initialized -> GlobalScope.launch {
                    viewModel.getStudentsList()
                }
                is UIState.InProgress -> progressBar.visibility = View.VISIBLE
                is UIState.NotInProgress -> progressBar.visibility = View.INVISIBLE
                is UIState.ShowList -> initList()
                is UIState.ShowError -> {
                    viewModel.uiState.value = UIState.NotInProgress
                    Toast.makeText(context, getString(R.string.error_message), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun initList() {
        layoutManager = LinearLayoutManager(context)
        studentsRecyclerView.layoutManager = layoutManager
        studentsListAdapter = StudentsListAdapter(viewModel.getPreparedList())
        studentsRecyclerView.adapter = studentsListAdapter
        viewModel.uiState.value = UIState.NotInProgress
    }
}