package io.github.josebatista.composemasterclass.state_management.todo_list

data class TodoListState(
    val todos: List<Todo> = (1..15).map {
        Todo(
            title = "Todo $it",
            description = "Description for todo $it",
            isChecked = false
        )
    },
    val newTodoTitle: String = "",
    val newTodoDescription: String = ""
)
