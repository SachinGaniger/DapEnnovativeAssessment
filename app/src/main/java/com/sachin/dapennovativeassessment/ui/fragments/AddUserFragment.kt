package com.sachin.dapennovativeassessment.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sachin.dapennovativeassessment.R
import com.sachin.dapennovativeassessment.databinding.FragmentAddUserBinding
import com.sachin.dapennovativeassessment.db.User
import com.sachin.dapennovativeassessment.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserFragment : Fragment(R.layout.fragment_add_user) {

    lateinit var binding: FragmentAddUserBinding
    var name: String? = null
    var dob: String? = null
    var location: String? = null
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddUserBinding.inflate(inflater, container, false)

        binding.apply {



            btAdd.setOnClickListener {
                Log.i("Clicked: ", "button clicked");
                name = etName.text.toString()
                dob = etDob.text.toString()
                location = etLocation.text.toString()

                var user = User(name, dob, location)
                addUser(user)
                findNavController().popBackStack()
            }

        }

        return binding.root
    }

    private fun addUser(user: User) {
        viewModel.addUser(user)
    }

}