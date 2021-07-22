package com.sachin.dapennovativeassessment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sachin.dapennovativeassessment.R
import com.sachin.dapennovativeassessment.databinding.FragmentHomeBinding
import com.sachin.dapennovativeassessment.databinding.FragmentUserListBinding
import com.sachin.dapennovativeassessment.db.User
import com.sachin.dapennovativeassessment.ui.adapters.UserListAdapter
import com.sachin.dapennovativeassessment.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment(R.layout.fragment_user_list) {

    lateinit var binding: FragmentUserListBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserListBinding.inflate(inflater, container, false)

        viewModel.getUsers()

         viewModel.getAllUsers().observe(viewLifecycleOwner, Observer {users ->

             val userListAdapter = UserListAdapter(users) {user, type ->
                 if(type == "delete"){
                     viewModel.deleteUser(user)

                 } else if(type == "edit"){
//                viewModel.updateUser(user)
//                findNavController().popBackStack()
                 }
             }

             binding.rvUsers.apply {
                 this.layoutManager = LinearLayoutManager(activity)
                 this.adapter = userListAdapter
             }
        })






        return binding.root
    }

}