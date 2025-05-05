package io.github.josebatista.composemasterclass.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun LazyGridDemo(modifier: Modifier = Modifier) {
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(50.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(100) {
//            Box(
//                modifier = Modifier
//                    .width(width = Random.nextInt(1..200).dp)
//                    .height(100.dp)
//                    .background(Color(Random.nextInt()))
//            )
//        }
//    }
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(100) {
            Box(
                modifier = Modifier
                    .height(height = Random.nextInt(1..200).dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(Random.nextInt()))
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LazyGridDemoPreview() {
    ComposeMasterClassTheme {
        LazyGridDemo()
    }
}
