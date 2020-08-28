package pl.norberthanysz.studentslist.ui.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pl.norberthanysz.studentslist.R
import pl.norberthanysz.studentslist.databinding.StudentsListFragmentBinding
import pl.norberthanysz.studentslist.models.UIState

class StudentsListFragment : Fragment() {

    private lateinit var binding: StudentsListFragmentBinding
    private lateinit var viewModel: StudentsListViewModel

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
                is UIState.Initialized -> {}
                is UIState.InProgress -> {}
                is UIState.NotInProgress -> {}
                is UIState.ShowList -> {}
                is UIState.ShowError -> {}
            }
        })
    }
}