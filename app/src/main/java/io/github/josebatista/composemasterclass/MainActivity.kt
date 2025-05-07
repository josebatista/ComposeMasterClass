package io.github.josebatista.composemasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.basic_modifier.SpacingModifierDemo
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMasterClassTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    TodoListRoot(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }

                // Scaffold has default paddings values
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.safeGestures
                ) { innerPadding ->
                    SpacingModifierDemo(
                        modifier = Modifier
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding)
//                        .statusBarsPadding() // add padding to status bar
//                        .navigationBarsPadding() // add padding to navigation bar
//                        .safeGesturesPadding() // add padding to navigation bar, status bar and horizontal paddings
//                        .safeContentPadding()  // add padding to navigation bar, status bar and vertical paddings
//                        .safeDrawingPadding()
//                        .windowInsetsPadding(WindowInsets.ime)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeMasterClassTheme {
        // Scaffold has default paddings values
//        Scaffold(
//            modifier = Modifier.fillMaxSize()
//        ) { innerPadding ->
//        }
        SpacingModifierDemo(
            modifier = Modifier
                .statusBarsPadding() // add padding to status bar
                .navigationBarsPadding() // add padding to navigation bar
        )
    }
}
