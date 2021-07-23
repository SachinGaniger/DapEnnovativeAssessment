package com.sachin.dapennovativeassessment.ui.fragments

import android.app.AlertDialog
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
import com.sachin.dapennovativeassessment.databinding.EditUserLayoutBinding
import com.sachin.dapennovativeassessment.databinding.FragmentHomeBinding
import com.sachin.dapennovativeassessment.databinding.FragmentUserListBinding
import com.sachin.dapennovativeassessment.db.User
import com.sachin.dapennovativeassessment.ui.adapters.UserListAdapter
import com.sachin.dapennovativeassessment.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Array

@AndroidEntryPoint
class UserListFragment : Fragment(R.layout.fragment_user_list) {

    lateinit var binding: FragmentUserListBinding
    private val viewModel: UserViewModel by viewModels()
    private var userListAdapter: UserListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserListBinding.inflate(inflater, container, false)

        viewModel.getUsers()

         viewModel.getAllUsers().observe(viewLifecycleOwner, Observer {users ->

             userListAdapter = UserListAdapter(users as ArrayList<User>) { user, type ->
                 if(type == "delete"){
                     viewModel.deleteUser(user)

                 } else if(type == "edit"){
//                viewModel.updateUser(user)
                    showEditDialog(user)
                 }
             }

             binding.rvUsers.apply {
                 this.layoutManager = LinearLayoutManager(activity)
                 this.adapter = userListAdapter
             }
        })






        return binding.root
    }

    private fun showEditDialog(user: User) {

        val dialogBinding = EditUserLayoutBinding.inflate(LayoutInflater.from(activity))

        val dialogBuilder = activity?.let {
            androidx.appcompat.app.AlertDialog.Builder(it)
                .setView(dialogBinding.root)
                .setTitle("Edit User")
        }

        val alertDialog = dialogBuilder?.show()

        dialogBinding.apply {

            etName.setText(user.name)
            etDob.setText(user.dob)
            etLocation.setText(user.location)

            btEdit.setOnClickListener {

                user.name = etName.text.toString()
                user.dob = etDob.text.toString()
                user.location = etLocation.text.toString()

                viewModel.updateUser(user)
                userListAdapter?.notifyDataSetChanged()
                alertDialog?.dismiss()
            }

            btCancel.setOnClickListener {
                alertDialog?.dismiss()
            }
        }


    }

}