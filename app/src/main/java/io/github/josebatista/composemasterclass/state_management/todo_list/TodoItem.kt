package io.github.josebatista.composemasterclass.state_management.todo_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun TodoItem(
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit,
    todo: Todo,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = todo.title,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
            Text(
                text = todo.description,
                overflow = TextOverflow.Ellipsis,
                textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
        }
        Checkbox(
            checked = todo.isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoItemPreview() {
    ComposeMasterClassTheme {
        TodoItem(
            todo = Todo(
                title = "Bring out the trash",
                description = "Better do this before wife comes home.",
                isChecked = false
            ),
            onCheckedChange = {}
        )
    }
}
