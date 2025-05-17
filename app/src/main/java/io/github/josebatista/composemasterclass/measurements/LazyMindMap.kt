package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMapIndexedNotNull
import kotlin.math.roundToInt

data class MindMapItem(
    val title: String,
    val percentageOffset: Offset
)

private data class ProcessedMindMapItem(
    val placeable: Placeable,
    val finalXPosition: Int,
    val finalYPosition: Int
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyMindMap(
    modifier: Modifier = Modifier,
    items: List<MindMapItem> = emptyList(),
    itemModifier: Modifier = Modifier,
    mindMapOffset: IntOffset = IntOffset.Zero,
    onDrag: (delta: IntOffset) -> Unit,
) {
    LazyLayout(
        modifier = modifier
            .draggable2D(
                state = rememberDraggable2DState { delta ->
                    onDrag(delta.round())
                }
            ),
        itemProvider = {
            object : LazyLayoutItemProvider {
                override val itemCount: Int
                    get() = items.size

                @Composable
                override fun Item(index: Int, key: Any) {
                    Text(
                        text = items[index].title,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        modifier = itemModifier
                            .widthIn(min = 50.dp, max = 150.dp)
                            .heightIn(min = 50.dp, max = 75.dp)
                            .border(width = 2.dp, color = Color.DarkGray)
                            .padding(16.dp)
                    )
                }
            }
        }
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
            val finalXPosition =
                (item.percentageOffset.x * layoutWidth + layoutWidth / 2 + mindMapOffset.x).roundToInt()
            val finalYPosition =
                (item.percentageOffset.y * layoutHeight + layoutHeight / 2 + mindMapOffset.y).roundToInt()
            val maxItemWidth = 150.dp.roundToPx()
            val maxItemHeight = 75.dp.roundToPx()
            val extendedItemBounds = IntRect(
                left = finalXPosition - maxItemWidth / 2,
                top = finalYPosition - maxItemHeight / 2,
                right = finalXPosition + 3 * (maxItemWidth / 2),
                bottom = finalYPosition + 3 * (maxItemHeight / 2)
            )
            if (visibleArea.overlaps(extendedItemBounds)) {
                val placeable = measure(
                    index = index,
                    constraints = Constraints()
                ).first()
                ProcessedMindMapItem(
                    placeable = placeable,
                    finalXPosition = finalXPosition,
                    finalYPosition = finalYPosition
                )
            } else {
                null
            }
        }

        println("===> visible items: ${visibleItems.size}")

        layout(constraints.maxWidth, constraints.maxHeight) {
            visibleItems.fastForEach { item ->
                item.placeable.place(
                    x = item.finalXPosition - item.placeable.width / 2,
                    y = item.finalYPosition - item.placeable.height / 2
                )
            }
        }
    }
}
