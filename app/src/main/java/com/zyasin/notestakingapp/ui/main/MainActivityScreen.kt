package com.zyasin.notestakingapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zyasin.notestakingapp.R
import com.zyasin.notestakingapp.model.TaskEntity
import com.zyasin.notestakingapp.ui.main.viewmodel.TaskViewModel


// These composables defined here instead of in MainActivity to keep code more cleaner and modular
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    taskViewModel: TaskViewModel,
    navController: NavHostController,
    tasks: List<TaskEntity>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.title_main_activity),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center // Center the title
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("addNote")
                },
                containerColor = MaterialTheme.colorScheme.primary // Set primary color for the FAB
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Note")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            TaskList(tasks = tasks)
        }
    }
}

@Composable
fun TaskList(tasks: List<TaskEntity>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .padding(16.dp)
    ) {
        items(tasks) { task ->
            Text(text = task.message, style = MaterialTheme.typography.bodyLarge)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}


@Composable
fun AddTaskButton(navController: NavHostController) {
    Button(
        onClick = {
            navController.navigate("addNote")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(48.dp)
    ) {
        Text("Add New Task")
    }
}