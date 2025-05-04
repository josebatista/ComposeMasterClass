package io.github.josebatista.composemasterclass.basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.R
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    /**
     * Initial Box tests
     */
//    Box(
//        modifier = Modifier
//            .size(200.dp),
//        contentAlignment = Alignment.BottomCenter
//    ) {
//        Text(
//            text = "Hello world!",
//            modifier = Modifier
//                .align(Alignment.TopStart)
//        )
//        Text("What's App?")
//    }

    /**
     * Image Box tests
     */
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.kermit),
            contentDescription = "Kermit the Frog"
        )
        Box(
            modifier = Modifier
                // .fillMaxSize() // entire screen, because the external Box don't have a specific size
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black)
                    )
                )
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = Color.White
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
fun BoxDemoPreview() {
    ComposeMasterClassTheme {
        BoxDemo()
    }
}
