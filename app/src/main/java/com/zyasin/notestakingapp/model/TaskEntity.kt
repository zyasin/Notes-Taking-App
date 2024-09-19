package com.zyasin.notestakingapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Represents a database table
@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val message: String
)