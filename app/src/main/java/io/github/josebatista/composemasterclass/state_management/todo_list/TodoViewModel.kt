package io.github.josebatista.composemasterclass.state_management.todo_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel : ViewModel() {
    private val _state = MutableStateFlow(TodoListState())
    val state = _state.asStateFlow()

    fun onAction(action: TodoListAction) {
        when (action) {
            TodoListAction.OnAddTodoClick -> {
                val title = state.value.newTodoTitle
                val description = state.value.newTodoDescription
                if (title.isNotBlank()) {
                    val newTodo = Todo(
                        title = title,
                        description = description,
                        isChecked = false
                    )
                    _state.update {
                        it.copy(
                            todos = it.todos + newTodo,
                            newTodoTitle = "",
                            newTodoDescription = ""
                        )
                    }
                }
            }

            is TodoListAction.OnDeletedTodoClick -> {
                _state.update {
                    it.copy(
                        todos = it.todos.filter { todo -> todo != action.todo }
                    )
                }
            }

            is TodoListAction.OnDescriptionChange -> {
                _state.update {
                    it.copy(
                        newTodoDescription = action.description
                    )
                }
            }

            is TodoListAction.OnTitleChange -> {
                _state.update {
                    it.copy(
                        newTodoTitle = action.title
                    )
                }
            }

            is TodoListAction.OnToggleTodo -> {
                _state.update {
                    it.copy(
                        todos = it.todos.map { todo ->
                            if (todo == action.todo) {
                                todo.copy(isChecked = !todo.isChecked)
                            } else todo
                        }
                    )
                }
            }
        }
    }
}
