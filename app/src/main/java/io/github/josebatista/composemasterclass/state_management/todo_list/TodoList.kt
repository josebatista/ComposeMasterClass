package io.github.josebatista.composemasterclass.state_management.todo_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun TodoListRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<TodoViewModel>()
    val state = viewModel.state.collectAsStateWithLifecycle()
    TodoList(
        modifier = modifier,
        state = state.value,
        onAction = viewModel::onAction
    )
}

@Composable
private fun TodoList(
    state: TodoListState,
    onAction: (TodoListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(state.todos) { todo ->
                TodoItem(
                    todo = todo,
                    onCheckedChange = { onAction(TodoListAction.OnToggleTodo(todo)) },
                    onDeletedClick = { onAction(TodoListAction.OnDeletedTodoClick(todo)) },
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                TextField(
                    value = state.newTodoTitle,
                    onValueChange = { onAction(TodoListAction.OnTitleChange(it)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text("Title") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = state.newTodoDescription,
                    onValueChange = { onAction(TodoListAction.OnDescriptionChange(it)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text("Description") }
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { onAction(TodoListAction.OnAddTodoClick) }) {
                Text("Add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoListPreview() {
    ComposeMasterClassTheme {
        TodoList(
            state = TodoListState(),
            onAction = {}
        )
    }
}
