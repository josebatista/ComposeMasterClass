package io.github.josebatista.composemasterclass.side_effects

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EffectHandlerViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    val snackbarHostState = SnackbarHostState()
    val lazyListState = LazyListState()
    val showButtonToTop = snapshotFlow {
        lazyListState.firstVisibleItemIndex >= 10
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000L),
        false
    )

    init {
        viewModelScope.launch {
            counter.collectLatest { counter ->
                if (counter % 2 == 0) {
                    snackbarHostState.showSnackbar("The number is even!")
                }
            }
        }
    }

    fun increaseCounter() {
        _counter.value++
    }

    fun scrollToTop(uiScope: CoroutineScope) {
        viewModelScope.launch {
            withContext(uiScope.coroutineContext) {
                lazyListState.animateScrollToItem(0)
            }
        }
    }
}

@Composable
fun LaunchedEffectDemo2(modifier: Modifier = Modifier) {
//    var counter by remember { mutableIntStateOf(0) }
//    val snackbarHostState = remember { SnackbarHostState() }

    val viewModel = viewModel<EffectHandlerViewModel>()
    val counter by viewModel.counter.collectAsStateWithLifecycle()
    val snackbarHostState = viewModel.snackbarHostState
    val showButtonToTop by viewModel.showButtonToTop.collectAsStateWithLifecycle()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->

    }

    /*
    This will be executed only once, when the composable is first composed/shown on the screen.
     */
    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.RECORD_AUDIO)
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        floatingActionButton = {
            if (showButtonToTop) {
                FloatingActionButton(
                    onClick = {
                        viewModel.scrollToTop(scope)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Scroll to top"
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                state = viewModel.lazyListState,
                modifier = Modifier
                    .weight(1f)
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
            Button(
                onClick = {
//                counter++
                    viewModel.increaseCounter()
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Counter: $counter")
            }
        }
    }
}

@Preview
@Composable
private fun LaunchedEffectDemoPreview() {
    ComposeMasterClassTheme {
        LaunchedEffectDemo()
    }
}
