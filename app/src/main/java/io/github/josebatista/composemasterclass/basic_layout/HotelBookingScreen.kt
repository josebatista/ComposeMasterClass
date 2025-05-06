package io.github.josebatista.composemasterclass.basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import io.github.josebatista.composemasterclass.R
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

private val tags = listOf(
    "City-Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deal",
    "Early Bird Discount",
    "Romantic Gateway",
    "24/7 Support"
)

private val offers = mapOf(
    R.drawable.bed to "2 Bed",
    R.drawable.breakfast to "Breakfast",
    R.drawable.cutlery to "Kitchen",
    R.drawable.pawprint to "Pet Friendly",
    R.drawable.serving_dish to "Dinner",
    R.drawable.snowflake to "Air Conditioning",
    R.drawable.television to "TV",
    R.drawable.wi_fi_icon to "Wifi"
)

@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { BookingHeader() }
        item { HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp)) }
        item { BookingTags(tags) }
        item { HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp)) }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = """
                    The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.'s best attractions.
                """.trimIndent(),
                fontSize = 13.sp,
                textAlign = TextAlign.Justify
            )
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "What we offer",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        item { Offers(offers) }
        item {
            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(
                        max = 400.dp
                    )
                    .fillMaxWidth(),
                onClick = {}
            ) {
                Text("Book Now")
            }
        }
    }
}


@Composable
private fun BookingHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(R.drawable.living_room),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 300.dp),
            contentScale = ContentScale.Crop
        )
        Header()
    }
}

@Composable
private fun Header() {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    Row(
        modifier = Modifier
            .background(Color.LightGray.copy(alpha = 0.7f))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Hotel California Strawberry",
                fontSize = when (windowSizeClass.windowWidthSizeClass) {
                    WindowWidthSizeClass.MEDIUM -> 24.sp
                    WindowWidthSizeClass.EXPANDED -> 28.sp
                    else -> 18.sp
                },
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            HeaderInfoItem(
                text = "Los Angeles, California",
                icon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )

                }
            )
            HeaderInfoItem(
                text = "4.9 (14K reviews)",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                }
            )
        }
        Text(
            text = buildAnnotatedString {
                val fontSizeMultiplier = when (windowSizeClass.windowWidthSizeClass) {
                    WindowWidthSizeClass.MEDIUM -> 1.2f
                    WindowWidthSizeClass.EXPANDED -> 1.5f
                    else -> 1f
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp * fontSizeMultiplier
                    )
                ) {
                    append("$420/")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp * fontSizeMultiplier
                    )
                ) {
                    append("night")
                }
            }
        )
    }
}

@Composable
private fun HeaderInfoItem(
    text: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun BookingTags(
    details: List<String>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        details.forEach { tag ->
            AssistChip(onClick = {}, label = { Text(text = tag) })
        }
    }
}

@Composable
private fun Offers(
    offers: Map<Int, String>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        items(offers.entries.toList()) { (drawableResId, label) ->
            Column(
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.3f))
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(36.dp),
                    imageVector = ImageVector.vectorResource(id = drawableResId),
                    contentDescription = label,
                )
                Text(
                    text = label,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun HotelBookingScreenPreview() {
    ComposeMasterClassTheme {
        HotelBookingScreen()
    }
}

@Preview(
    device = Devices.NEXUS_10
)
@Composable
private fun HotelBookingScreenTabletPreview() {
    ComposeMasterClassTheme {
        HotelBookingScreen()
    }
}
