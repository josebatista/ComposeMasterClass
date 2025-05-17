package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMapIndexedNotNull
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme
import kotlin.math.roundToInt

@Composable
fun LazyMindMapFlexibleRoot(modifier: Modifier = Modifier) {
    var offset by remember { mutableStateOf(IntOffset.Zero) }
    var counter by remember { mutableIntStateOf(0) }
    val items = listOf(
        MindMapItemFlex(
            offset = Offset.Zero,
            constraints = Constraints(
                maxWidth = 2000,
                maxHeight = 1500
            ),
            content = {
                Column(
                    modifier = Modifier
                        .border(width = 2.dp, color = Color.Gray)
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = counter.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                    Row {
                        Button(onClick = { counter-- }) { Text("Dec") }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = { counter++ }) { Text("Inc") }
                    }
                }
            }
        ),
        MindMapItemFlex(
            offset = Offset(-700f, -700f),
            constraints = Constraints(
                maxWidth = 2000,
                maxHeight = 1500
            ),
            content = {
                Text(
                    text = "Hello World!",
                    modifier = Modifier
                        .border(width = 2.dp, color = Color.Gray)
                        .padding(16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp
                )
            }
        )
    )
    LazyMindMapFlexible(
        items = items,
        mindMapOffset = offset,
        onDrag = {
            offset += it
        },
        modifier = modifier
            .fillMaxSize()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LazyMindMapFlexible(
    modifier: Modifier = Modifier,
    items: List<MindMapItemFlex>,
    mindMapOffset: IntOffset,
    onDrag: (delta: IntOffset) -> Unit,
) {
    LazyLayout(
        itemProvider = {
            object : LazyLayoutItemProvider {
                override val itemCount: Int
                    get() = items.size

                @Composable
                override fun Item(index: Int, key: Any) {
                    val item = items[index]
                    Layout(
                        content = item.content,
                        measurePolicy = { measurables, _ ->
                            val placeables = measurables.map { it.measure(item.constraints) }
                            val maxWidth = placeables.maxOfOrNull { it.width } ?: 0
                            val maxHeight = placeables.maxOfOrNull { it.height } ?: 0
                            layout(maxWidth, maxHeight) {
                                placeables.fastForEach { it.place(0, 0) }
                            }
                        }
                    )
                }
            }
        },
        modifier = modifier
            .draggable2D(state = rememberDraggable2DState { delta -> onDrag(delta.round()) })
    ) { constraints ->
        val layoutWidth = constraints.maxWidth
        val layoutHeight = constraints.maxHeight
        val visibleArea = IntRect(
            left = 0,
            top = 0,
            right = layoutWidth,
            bottom = layoutHeight
        )
        val visibleItems = items.fastMapIndexedNotNull { index, item ->
            val finalXPosition = (item.offset.x + layoutWidth / 2 + mindMapOffset.x).roundToInt()
            val finalYPosition = (item.offset.y + layoutHeight / 2 + mindMapOffset.y).roundToInt()
            val maxItemWidth = item.constraints.maxWidth
            val maxItemHeight = item.constraints.maxHeight
            val extendedItemBounds = IntRect(
                left = finalXPosition - maxItemWidth / 2,
                top = finalYPosition - maxItemHeight / 2,
                right = finalXPosition + 3 * (maxItemWidth / 2),
                bottom = finalYPosition + 3 * (maxItemHeight / 2)
            )
            if (visibleArea.overlaps(extendedItemBounds)) {
                val placeables = measure(
                    index = index,
                    constraints = item.constraints
                )
                placeables.map {
                    ProcessedMindMapItemFlex(
                        finalXPosition = finalXPosition,
                        finalYPosition = finalYPosition,
                        placeable = it
                    )
                }
            } else null
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            visibleItems.flatten().fastForEach { item ->
                item.placeable.place(
                    item.finalXPosition - item.placeable.width / 2,
                    item.finalYPosition - item.placeable.height / 2
                )
            }
        }
    }
}

private data class ProcessedMindMapItemFlex(
    val finalXPosition: Int,
    val finalYPosition: Int,
    val placeable: Placeable
)

private data class MindMapItemFlex(
    val offset: Offset,
    val constraints: Constraints,
    val content: @Composable () -> Unit
)

@Preview(
    showBackground = true
)
@Composable
private fun LazyMindMapFlexibleRootPreview() {
    ComposeMasterClassTheme {
        LazyMindMapFlexibleRoot()
    }
}
