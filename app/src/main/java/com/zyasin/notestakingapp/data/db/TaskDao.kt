package com.zyasin.notestakingapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zyasin.notestakingapp.model.TaskEntity
import kotlinx.coroutines.flow.Flow


// Defines data access methods for the tasks table
@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getTasks(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    // Delete all tasks
    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()
}