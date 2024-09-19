package com.zyasin.notestakingapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import com.zyasin.notestakingapp.data.db.AppDatabase
import com.zyasin.notestakingapp.ui.main.viewmodel.TaskViewModel
import com.zyasin.notestakingapp.ui.main.viewmodel.TaskViewModelFactory
import com.zyasin.notestakingapp.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the database and taskDao instance
        val taskDao = AppDatabase.getDatabase(applicationContext).taskDao()

        // Create TaskViewModel using the factory
        val taskViewModel: TaskViewModel by viewModels {
            TaskViewModelFactory(taskDao)
        }

        setContent {
            // Instance of NavController that is remembered across recompositions
            val navController = rememberNavController()

            // Setup the navigation and theme
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavGraph(navController = navController, taskViewModel = taskViewModel)
                }
            }
        }
    }
}
