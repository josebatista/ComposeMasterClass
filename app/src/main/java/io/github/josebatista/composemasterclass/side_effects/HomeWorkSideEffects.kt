package io.github.josebatista.composemasterclass.side_effects

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

data class HomeWorkSideEffectsState(
    val list: List<String> = List(100) { "Item $it" }
)

class HomeWorkSideEffectsViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeWorkSideEffectsState())
    val state = _state.asStateFlow()

    val snackbarHostState = SnackbarHostState()
    val lazyListState = LazyListState()

    init {
        snapshotFlow {
            val layoutInfo = lazyListState.layoutInfo
            layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
        }.onEach { isScrolledToBottom ->
            if (isScrolledToBottom) {
                snackbarHostState.showSnackbar("Scrolled to the bottom!")
            }
        }.launchIn(viewModelScope)
    }
}

@Composable
fun HomeWorkSideEffectsRoot(
    modifier: Modifier = Modifier,
) {
    val viewModel = viewModel<HomeWorkSideEffectsViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackbarHostState = viewModel.snackbarHostState
    val lazyListState = viewModel.lazyListState

    HomeWorkSideEffects(
        modifier = modifier,
        list = state.list,
        snackbarHostState = snackbarHostState,
        lazyListState = lazyListState
    )
}

@Composable
fun HomeWorkSideEffects(
    modifier: Modifier = Modifier,
    list: List<String>,
    snackbarHostState: SnackbarHostState,
    lazyListState: LazyListState
) {
    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(list) {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun HomeWorkSideEffectsPreview() {
    ComposeMasterClassTheme {
        HomeWorkSideEffectsRoot()
    }
}
