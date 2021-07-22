package com.sachin.dapennovativeassessment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.dapennovativeassessment.db.User
import com.sachin.dapennovativeassessment.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    var users : MutableLiveData<List<User>> = MutableLiveData()

    public fun getUsers() =
        viewModelScope.launch(Dispatchers.IO) {
            users.postValue(userRepository.getAllUsers())
        }

    public fun getAllUsers(): LiveData<List<User>>{
        return users
    }


    public fun addUser(user: User) =
      viewModelScope.launch(Dispatchers.IO) {
          userRepository.insertUser(user)
      }

    public fun deleteUser(user: User) =
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)
        }

    public fun updateUser(user: User) =
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }

}