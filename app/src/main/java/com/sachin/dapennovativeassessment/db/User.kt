package com.sachin.dapennovativeassessment.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    var name: String?= null,
    var dob: String?= null,
    var location: String?= null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int?= null
}