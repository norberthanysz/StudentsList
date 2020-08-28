package pl.norberthanysz.studentslist.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pl.norberthanysz.studentslist.R
import pl.norberthanysz.studentslist.databinding.SplashFragmentBinding

class SplashFragment : Fragment() {

    private val splashScreenDelay: Long = 2000

    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.splash_fragment, container, false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this
        binding.view = this

        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_studentsListFragment)
        }, splashScreenDelay)
    }


}