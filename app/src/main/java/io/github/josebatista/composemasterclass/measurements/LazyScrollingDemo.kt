package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun LazyScrollingDemo(modifier: Modifier = Modifier) {
    /*
     Nesting scroll - LazyColumn inside a LazyColumn without fixed size will crash the app
     */
//    LazyColumn(
//        modifier = modifier.fillMaxSize()
//    ) {
//        items(20) {
//            Text(
//                text = "Item $it",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            )
//        }
//        item {
//            LazyColumn {
//                items(10) {
//                    Text(
//                        text = "Item $it",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    )
//                }
//            }
//        }
//    }

    /*
     Nesting scroll - LazyColumn inside a LazyColumn with fixed size don't will crash the app
     */
//    LazyColumn(
//        modifier = modifier.fillMaxSize()
//    ) {
//        items(20) {
//            Text(
//                text = "Item $it",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            )
//        }
//        item {
//            LazyColumn(
//                modifier = Modifier
//                    .height(300.dp)
//            ) {
//                items(10) {
//                    Text(
//                        text = "Item $it",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    )
//                }
//            }
//        }
//    }

    /*
     Avoid Nesting scroll
     */
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(20) {
            Text(
                text = "Item $it",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        items(10) {
            Text(
                text = "Item $it",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LazyScrollingDemoPreview() {
    ComposeMasterClassTheme {
        LazyScrollingDemo()
    }
}
