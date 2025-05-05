package io.github.josebatista.composemasterclass.basic_layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo(modifier: Modifier = Modifier) {
    /**
     * Row don't show all the 30 items
     */
//    Row(
//        modifier = modifier
//            .fillMaxSize()
//    ) {
//        for (i in 1..30) {
//            AssistChip(
//                onClick = {},
//                label = { Text("Hello World") }
//            )
//        }
//    }

    /**
     * FlowRow show all the items
     * overFlow is deprecated.
     */

    var maxLines by remember { mutableIntStateOf(4) }

    FlowRow(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        maxLines = maxLines,
        overflow = FlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                IconButton(
                    onClick = {
                        maxLines = Int.MAX_VALUE
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand"
                    )
                }
            },
            collapseIndicator = {
                IconButton(
                    onClick = {
                        maxLines = 4
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Collapse"
                    )
                }
            }
        )
    ) {
        repeat(30) { i ->
            AssistChip(
                onClick = {},
                label = { Text("Item $i") }
            )
        }
    }

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
fun FlowLayoutDemoPreview() {
    ComposeMasterClassTheme {
        FlowLayoutDemo()
    }
}
