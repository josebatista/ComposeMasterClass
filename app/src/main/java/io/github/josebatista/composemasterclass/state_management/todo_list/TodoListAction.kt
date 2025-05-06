package io.github.josebatista.composemasterclass.state_management.todo_list

sealed interface TodoListAction {
    data object OnAddTodoClick : TodoListAction
    data class OnDeletedTodoClick(val todo: Todo) : TodoListAction
    data class OnToggleTodo(val todo: Todo) : TodoListAction
    data class OnTitleChange(val title: String) : TodoListAction
    data class OnDescriptionChange(val description: String) : TodoListAction
}
