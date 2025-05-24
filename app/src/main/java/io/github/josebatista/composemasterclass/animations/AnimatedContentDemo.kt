package io.github.josebatista.composemasterclass.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun AnimatedContentDemo(modifier: Modifier = Modifier) {
    var toggle by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { toggle = !toggle }) {
            Text("Toggle")
        }
        AnimatedContent(
            targetState = toggle,
            transitionSpec = {
//                slideIntoContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(durationMillis = 3_000)
//                ) togetherWith slideOutOfContainer(
//                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(durationMillis = 3_000)
//                )
                slideIntoContainer(
                    towards = if (toggle) {
                        AnimatedContentTransitionScope.SlideDirection.Right
                    } else {
                        AnimatedContentTransitionScope.SlideDirection.Left
                    },
                    animationSpec = tween(durationMillis = 3_000)
                ) togetherWith slideOutOfContainer(
                    towards = if (toggle) {
                        AnimatedContentTransitionScope.SlideDirection.Right
                    } else {
                        AnimatedContentTransitionScope.SlideDirection.Left
                    },
                    animationSpec = tween(durationMillis = 3_000)
                )
            }
        ) { toggle ->
            if (toggle) {
                Text(
                    text = "Hello world!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Red
                        )
                        .wrapContentSize()
                )
            } else {
                Text(
                    text = "Bye bye world!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp)
                        .border(
                            width = 5.dp,
                            color = Color.Green
                        )
                        .wrapContentSize()
                )
            }
        }
        Text(
            text = "I'm below!"
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun AnimatedContentDemoPreview() {
    ComposeMasterClassTheme {
        AnimatedContentDemo()
    }
}
