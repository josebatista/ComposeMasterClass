package io.github.josebatista.composemasterclass.basic_modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import io.github.josebatista.composemasterclass.R
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

@Composable
fun ShapeModifiersDemo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.kermit),
        contentDescription = "Kermit in the snow",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
//            .clip(CircleShape)
//            .clip(RectangleShape)
//            .clip(RoundedCornerShape(20.dp))
            .clip(TriangleShape)
    )
}

data object TriangleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            moveTo(
                x = size.width / 2,
                y = 0f
            )
            lineTo(
                x = 0f,
                y = size.height
            )
            lineTo(
                x = size.width,
                y = size.height
            )
            close()
        })
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ShapeModifiersDemoPreview() {
    ComposeMasterClassTheme {
        ShapeModifiersDemo()
    }
}
