package io.github.josebatista.composemasterclass.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {

    /**
     * Row Tests
     */
//    Row(
//        modifier = Modifier.fillMaxSize(),
//        verticalAlignment = Alignment.CenterVertically,
////        horizontalArrangement = Arrangement.SpaceAround,
//    ) {
////        Text(
////            text = "Hello World! José Pereira",
////            fontSize = 40.sp,
////            modifier = Modifier
////                .width(150.dp)
////                .alignBy(LastBaseline)
////        )
////        Text(
////            text = "Hello World!",
////            fontSize = 20.sp,
////            modifier = Modifier
////                .alignByBaseline()
////        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Red)
//        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Blue)
//                .align(Alignment.Top)
//        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Green)
//                .align(Alignment.Bottom)
//        )
//    }

    /**
     * Column Tests
     * Dynamic size
     */
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Red)
//                .weight(2f)
//        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Blue)
//                .weight(1f)
//        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Green)
//                .weight(1f)
//        )
//    }
    /**
     * Example Item List
     */
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .weight(3f),
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.Blue),
            )
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.Green),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun RowColumnDemoPreview() {
    ComposeMasterClassTheme {
        RowColumnDemo()
    }
}
