package io.github.josebatista.composemasterclass.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun LazyListDemo(modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier.fillMaxSize()
//    ) {
//        repeat(100) { i -> Text("Item $i") }
//    }

//    LazyRow {
//        items(100) {
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(Color(Random.nextInt()))
//            )
//        }
//    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) { i -> Text("Item $i") }
        stickyHeader {
            Text(
                text = "STICKY HEADER",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
            )
        }
        items(100) { i -> Text("Item ${i + 100}") }
        item {
            Text(
                text = "Reached the end!",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun LazyListDemoPreview() {
    ComposeMasterClassTheme {
        LazyListDemo()
    }
}
