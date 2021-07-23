package com.sachin.dapennovativeassessment.repository

import com.sachin.dapennovativeassessment.db.User
import com.sachin.dapennovativeassessment.db.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun insertUser(user: User) = userDao.insertUser(user)

    suspend fun deleteUser(user: User) = userDao.deleteUser(user)

    suspend fun updateUser(user: User) = userDao.updateUser(user)


    fun getAllUsers() = userDao.getAllUsers()

}