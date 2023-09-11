package com.example.navigationcomponent.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.MainActivity
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        navigate()

        return root
    }


    fun navigate() {

        binding.btnNavigate.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_new_graph)
            hideBottomBar()
        }

    }

    open fun hideBottomBar() {
        (activity as MainActivity).hideBottomBar()
    }


    override fun onStart() {
        super.onStart()
        showBottomBar()
    }

    open fun showBottomBar() {
        (activity as MainActivity).showBottomBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}