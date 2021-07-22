package com.sachin.dapennovativeassessment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sachin.dapennovativeassessment.R
import com.sachin.dapennovativeassessment.databinding.FragmentAddUserBinding
import com.sachin.dapennovativeassessment.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.apply {

            btAddUser.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_addUserFragment)
            }

            btViewUser.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_userListFragment)
            }

        }

        return binding.root
    }

}