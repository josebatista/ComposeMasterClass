package io.github.josebatista.composemasterclass.measurements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layout
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.currentValueOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

/*
Modifier factory, used when you need access to a Local*, or animation for example.
This way, avoid to use Composable annotation into Modifier extension which will always be recomposed.
 */

fun Modifier.improvedNegativePadding(horizontal: Dp): Modifier {
    return then(NegativePaddingElement(horizontal))
}

data class NegativePaddingElement(private val horizontal: Dp) :
    ModifierNodeElement<NegativePadding>() {
    override fun create(): NegativePadding {
        return NegativePadding(horizontal)
    }

    override fun update(node: NegativePadding) {
        // node.invalidateMeasurement()
        node.horizontal = horizontal
    }
}

class NegativePadding(
    var horizontal: Dp
) : LayoutModifierNode, Modifier.Node(), CompositionLocalConsumerModifierNode {
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val density = currentValueOf(LocalDensity)
        val px = with(density) {
            horizontal.roundToPx()
        }
        val placeable = measurable.measure(
            constraints = constraints.copy(
                minWidth = constraints.minWidth + 2 * px,
                maxWidth = constraints.maxWidth + 2 * px
            )
        )
        return layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}

/*
Simple Modifier extension, Composable annotation is a problem.
This way will always be recomposed.
 */

@Composable
fun Modifier.negativePadding(horizontal: Dp): Modifier {
    val density = LocalDensity.current
    val px = with(density) { horizontal.roundToPx() }
    return layout { measurable, constraints ->
        val placeable = measurable.measure(
            constraints = constraints.copy(
                minWidth = constraints.minWidth + 2 * px,
                maxWidth = constraints.maxWidth + 2 * px
            )
        )
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}

/*
Simple Modifier extension.
 */
fun Modifier.negativePadding2(horizontal: Dp): Modifier {
    return layout { measurable, constraints ->
        val placeable = measurable.measure(
            constraints = constraints.copy(
                minWidth = constraints.minWidth + 2 * horizontal.roundToPx(),
                maxWidth = constraints.maxWidth + 2 * horizontal.roundToPx()
            )
        )
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}

@Composable
fun MyList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "This is item 1",
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        HorizontalDivider(modifier = Modifier.negativePadding(16.dp))
        Text(
            text = "This is another item",
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        HorizontalDivider(modifier = Modifier.improvedNegativePadding(16.dp))
        Text(
            text = "And another one",
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {}) { Text(text = "Button 1") }
            Button(onClick = {}) { Text(text = "Button 2") }
            Button(onClick = {}) { Text(text = "Button 3") }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun MyListPreview() {
    ComposeMasterClassTheme {
        MyList()
    }
}
