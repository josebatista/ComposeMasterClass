package io.github.josebatista.composemasterclass.basic_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SpacingModifierDemo(modifier: Modifier = Modifier) {
    /**
     * Using padding and margin
     */
//    Column(
//        modifier = modifier
//            .size(100.dp)
//            .background(Color.Red)
//            .padding(horizontal = 16.dp)
//    ) {
//        Text(text = "Hello World")
//        Spacer(modifier = Modifier.height(16.dp)) // equivalent to margin
//        Text(
//            text = "Hello World",
//            modifier = Modifier.padding(top = 16.dp) // equivalent to margin
//        )
//    }

    /**
     * Window insets
     */
    Column(
        modifier = modifier
            .background(Color.Red)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .imeNestedScroll()
        ) {
            items(100) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.imePadding()
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun SpacingModifierPreview() {
    ComposeMasterClassTheme {
        SpacingModifierDemo()
    }
}
