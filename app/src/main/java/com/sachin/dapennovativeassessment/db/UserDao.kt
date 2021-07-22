package com.sachin.dapennovativeassessment.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun updateUser(user:User)

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<User>

}