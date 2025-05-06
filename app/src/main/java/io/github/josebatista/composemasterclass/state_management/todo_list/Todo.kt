package io.github.josebatista.composemasterclass.state_management.todo_list

data class Todo(
    val title: String,
    val description: String,
    val isChecked: Boolean = false
)
