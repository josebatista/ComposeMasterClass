package io.github.josebatista.composemasterclass.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInExpo
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun AnimatedVisibilityDemo(modifier: Modifier = Modifier) {
    var toggle by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = {
                toggle = !toggle
            }
        ) {
            Text(text = "Toggle")
        }
//        if (toggle) {
//            Text(
//                text = "Hello World!",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .padding(16.dp)
//                    .border(
//                        width = 5.dp,
//                        color = Color.Red
//                    )
//                    .wrapContentSize(),
//                textAlign = TextAlign.Center,
//            )
//        }
        val easing = EaseInExpo
//        val animationSpec: FiniteAnimationSpec<Float> = tween(
//            durationMillis = 5000,
//            delayMillis = 300,
//            easing = easing
//        )
//        val animationSpec: FiniteAnimationSpec<Float> = spring(Spring.DampingRatioHighBouncy)
//        val animationSpec: FiniteAnimationSpec<Float> = keyframes {
//            durationMillis = 5_000
//            0.0f at 2_500 using LinearEasing
//        }
        val animationSpecIn: FiniteAnimationSpec<Float> = keyframes {
            durationMillis = 5_000
            0.75f at 2_500 using EaseInExpo
            0.25f at 3_750 using LinearEasing
            1f at 5_000 using FastOutSlowInEasing
        }
        val animationSpecOut: FiniteAnimationSpec<Float> = spring(Spring.DampingRatioMediumBouncy)
        AnimatedVisibility(
            visible = toggle,
            enter = fadeIn(animationSpec = animationSpecIn) + scaleIn(animationSpec = animationSpecIn),
            exit = fadeOut(animationSpec = animationSpecOut) + scaleOut(animationSpec = animationSpecOut)
        ) {
            Text(
                text = "Hello World!",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .border(
                        width = 5.dp,
                        color = Color.Red
                    )
                    .wrapContentSize(),
                textAlign = TextAlign.Center,
            )
        }
        Text("Hello World!")
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun AnimatedVisibilityDemoPreview() {
    ComposeMasterClassTheme {
        AnimatedVisibilityDemo()
    }
}
