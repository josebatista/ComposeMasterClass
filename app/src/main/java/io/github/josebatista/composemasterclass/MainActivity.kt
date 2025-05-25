package io.github.josebatista.composemasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import io.github.josebatista.composemasterclass.basic_modifier.SpacingModifierDemo
import io.github.josebatista.composemasterclass.performance.homework.ListItemScreenRoot
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
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    contentWindowInsets = WindowInsets.safeGestures
//                ) { innerPadding ->
//                    SpacingModifierDemo(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .consumeWindowInsets(innerPadding)
////                        .statusBarsPadding() // add padding to status bar
////                        .navigationBarsPadding() // add padding to navigation bar
////                        .safeGesturesPadding() // add padding to navigation bar, status bar and horizontal paddings
////                        .safeContentPadding()  // add padding to navigation bar, status bar and vertical paddings
////                        .safeDrawingPadding()
////                        .windowInsetsPadding(WindowInsets.ime)
//                    )
//                    FocusManagementModifiersDemo(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    var page by remember { mutableIntStateOf(0) }
//                    Column(
//                        modifier = Modifier.padding(innerPadding)
//                    ) {
//                        SubcomposePagedRow(
//                            page = page,
//                        ) {
//                            repeat(100) {
//                                Box(
//                                    modifier = Modifier
//                                        .height(100.dp)
//                                        .width(Random.nextInt(300).dp)
//                                        .background(Color(Random.nextInt()))
//                                )
//                            }
//                        }
//                        Button(
//                            onClick = {
//                                page++
//                            }
//                        ) {
//                            Text("Next page")
//                        }
//                    }
//                    val mindMapItems = remember {
//                        listOf(
//                            MindMapItem(
//                                title = "Hello World 1",
//                                percentageOffset = Offset(x = 0f, y = 0f)
//                            ),
//                            MindMapItem(
//                                title = "Hello World 2",
//                                percentageOffset = Offset(x = 1f, y = 0f)
//                            ),
//                            MindMapItem(
//                                title = "Hello World 3",
//                                percentageOffset = Offset(x = 0.3f, y = -0.5f)
//                            ),
//                            MindMapItem(
//                                title = "Hello World 4",
//                                percentageOffset = Offset(x = -0.2f, y = 1.5f)
//                            ),
//                        )
//                    }
//                    var mindMapOffset by remember {
//                        mutableStateOf(IntOffset.Zero)
//                    }
//                    LazyMindMap(
//                        items = mindMapItems,
//                        mindMapOffset = mindMapOffset,
//                        onDrag = { delta ->
//                            mindMapOffset += delta
//                        },
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                    LazyMindMapFlexibleRoot(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                    var toggle by remember { mutableStateOf(false) }
//                    if (!toggle) {
//                        DisposableEffectDemo()
//                    }
//                    Button(
//                        onClick = { toggle = !toggle },
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .fillMaxSize()
//                            .wrapContentSize()
//                    ) {
//                        Text("Toggle")
//                    }
//                    RememberUpdatedStateDemo(modifier = Modifier.padding(innerPadding))
//                    LaunchedEffectDemo2(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                    HomeWorkSideEffectsRoot(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                    CompositionLocalProvider(
//                        LocalShape provides RectangleShape
//                    ) {
//                        MyShapedButton()
//                    }
//                Scaffold(
//                    snackbarHost = { SnackbarHost(hostState = LocalSnackbarState.current) }
//                ) { innerPadding ->
////                    HomeWorkCompositionLocals(
////                        modifier = Modifier
////                            .fillMaxSize()
////                            .padding(innerPadding)
////                    )
////                    MyScreen(
////                        modifier = Modifier
////                            .fillMaxSize()
////                            .padding(innerPadding)
////                    )
//                    ImageLoading(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                }
//                LazyListPerformance()
//                    PhotoPickerScreen(
//                        compressor = remember {
//                            BitmapCompressor(applicationContext)
//                        },
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                    KeysCustomLayout(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                    MovableContent(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                }
//                DeferredStateReads(
//                    modifier = Modifier
//                        .fillMaxSize()
//                )
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .semantics {
                            testTagsAsResourceId = true
                        }
                ) { innerPadding ->
//                    OverdrawDemo(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                    LazyListPerformance(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
                    ListItemScreenRoot(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
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
