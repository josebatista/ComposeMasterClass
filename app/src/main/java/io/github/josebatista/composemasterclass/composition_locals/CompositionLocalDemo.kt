package io.github.josebatista.composemasterclass.composition_locals

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

val LocalShape = compositionLocalOf { RectangleShape }

@Composable
fun CompositionLocalDemo(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Red
        )
    ) {
        CompositionLocalProvider(
            LocalContentColor provides Color.Green
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null
            )
            Text("Hello world!")
        }
    }
}

@Composable
fun MyShapedButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        shape = LocalShape.current
    ) {
        Text("Shaped button")
    }
}

@Composable
fun MyCustomTopAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides LocalTextStyle.current.copy(
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 28.sp
            )
        ) {
            title()
        }
    }
}

@Preview
@Composable
private fun CompositionLocalDemoPreview() {
    ComposeMasterClassTheme {
//        CompositionLocalDemo()
//        MyCustomTopAppBar {
//            Text("Hello world!")
//        }
        MyShapedButton()
    }
}
