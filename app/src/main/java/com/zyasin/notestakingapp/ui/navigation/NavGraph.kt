package com.zyasin.notestakingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zyasin.notestakingapp.ui.main.AddNoteScreen
import com.zyasin.notestakingapp.ui.main.MainScreen
import com.zyasin.notestakingapp.ui.main.viewmodel.TaskViewModel

// Handles the app's screen navigation, between the MainScreen and AddNoteScreen
@Composable
fun NavGraph(navController: NavHostController, taskViewModel: TaskViewModel) {
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(
                taskViewModel = taskViewModel,
                navController = navController,
                tasks = taskViewModel.tasks.collectAsState(initial = emptyList()).value
            )
        }
        composable("addNote") {
            AddNoteScreen(
                taskViewModel = taskViewModel,
                navController = navController
            )
        }
    }
}