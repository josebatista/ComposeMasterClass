package io.github.josebatista.composemasterclass.basic_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun DraggableModifiersDemo(modifier: Modifier = Modifier) {
    var offset by remember { mutableStateOf(Offset.Zero) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset { offset.round() }
                .draggable( // Only one axis can be draggable at a time
                    state = rememberDraggableState {
                        offset += Offset(
                            x = 0f,
                            y = it
                        )
                    },
                    orientation = Orientation.Vertical
                )
//                .draggable2D( // Both axes can be draggable at the same time
//                    state = rememberDraggable2DState { offset += it }
//                )
                .clip(CircleShape)
                .background(Color.Red)
        )
    }
}

@Preview
@Composable
private fun DraggableModifiersDemoPreview() {
    ComposeMasterClassTheme {
        DraggableModifiersDemo()
    }
}
