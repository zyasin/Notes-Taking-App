package com.zyasin.notestakingapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.zyasin.notestakingapp.data.db.TaskDao
import com.zyasin.notestakingapp.model.TaskEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao: TaskDao) : ViewModel() {

    val tasks: StateFlow<List<TaskEntity>> = taskDao.getTasks()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())



    fun addTask(message: String) {
        Log.d("TaskViewModel", "Adding task with message: $message")
        viewModelScope.launch {
            val task = TaskEntity(message = message)
            taskDao.insertTask(task)
            Log.d("TaskViewModel", "Task added successfully")
        }
    }

}
class TaskViewModelFactory(private val taskDao: TaskDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(taskDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}





