package io.github.josebatista.composemasterclass.side_effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MyViewModel : ViewModel() {

    private var stating by mutableIntStateOf(0)
    val state = snapshotFlow {
        stating
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        0
    )

//    private val _state = MutableStateFlow(0)
//    val state = _state.asStateFlow()
}

@Composable
fun MyComposable(modifier: Modifier = Modifier) {
    val viewModel = viewModel<MyViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
}
