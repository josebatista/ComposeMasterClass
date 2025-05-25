package io.github.josebatista.composemasterclass.performance

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag

@Composable
fun LazyListPerformance(modifier: Modifier = Modifier) {
    var myList by remember {
        mutableStateOf(
            (1..100).map {
                MyListItem(
                    id = it,
                    title = "List item $it",
                    description = "Description $it"
                )
            }
        )
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    myList = listOf(
                        MyListItem(
                            id = myList.lastIndex + 1,
                            title = "List item ${myList.lastIndex + 1}",
                            description = "Description ${myList.lastIndex + 1}"
                        ),
                    ) + myList
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add item"
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .testTag("main_list")
        ) {
            items(
                items = myList,
                key = { it.id } // avoid unnecessary recompositions
            ) { item ->
                ListItem(
                    headlineContent = { Text(text = item.title) },
                    supportingContent = { Text(text = item.description) },
                    trailingContent = {
                        IconButton(
                            onClick = {
                                myList -= item
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = Color.Red
                            )
                        }
                    }
                )
            }
        }
    }
}

data class MyListItem(
    val id: Int,
    val title: String,
    val description: String
)
