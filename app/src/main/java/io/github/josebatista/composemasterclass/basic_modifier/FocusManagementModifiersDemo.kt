package io.github.josebatista.composemasterclass.basic_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun FocusManagementModifiersDemo(modifier: Modifier = Modifier) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Down
                    )
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        var isFocused by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 3.dp,
                    color = if (isFocused) Color.Green else Color.Gray
                )
                .onFocusChanged {
//                    isFocused = it.isFocused // specific when composable has focus
                    isFocused = it.hasFocus // used when any child has focus
                }
//                .focusable() // add focus to a composable that is not focusable by default
                .focusGroup() // add focus to a group of composables (child)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = "",
                onValueChange = {},
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(
                            focusDirection = FocusDirection.Down
                        )
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
            TextField(
                value = "",
                onValueChange = {},
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(
                            focusDirection = FocusDirection.Down
                        )
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
        }
        TextField(
            value = "",
            onValueChange = {},
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Down
                    )
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = "",
            onValueChange = {},
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Down
                    )
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        Button(
            onClick = {
                focusRequester.requestFocus()
            }
        ) {
            Text("Start filling out form")
        }
        Button(
            onClick = {
                focusManager.clearFocus()
            }
        ) {
            Text("Clear Focus")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FocusManagementModifiersDemoPreview() {
    ComposeMasterClassTheme {
        FocusManagementModifiersDemo()
    }
}
