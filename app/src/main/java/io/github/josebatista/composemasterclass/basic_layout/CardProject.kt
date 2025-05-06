package io.github.josebatista.composemasterclass.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.josebatista.composemasterclass.ui.theme.ComposeMasterClassTheme

data class Project(
    val title: String,
    val description: String,
    val formattedDateTime: String
)

/**
 * Homework
 */

@Composable
fun CardProject(
    project: Project,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFFE87457))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = null,
                tint = Color.White
            )
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = project.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(90f),
                    tint = Color.White
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(start = 36.dp),
            text = project.description,
            color = Color.White
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = project.formattedDateTime,
            color = Color.White,
            textAlign = TextAlign.End
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun MediumHomeworkPreview() {
    ComposeMasterClassTheme {
        CardProject(
            project = Project(
                title = "Project X",
                description = """
                Bacon ipsum dolor amet meatloaf andouille landjaeger, turducken turkey chuck flank tongue. Alcatra chislic shankle strip steak ball tip beef venison. Doner spare ribs shank ham hock, turkey filet mignon buffalo rump cupim corned beef drumstick. Pork corned beef pig shoulder cow sausage picanha prosciutto doner beef ribs brisket bacon.
            """.trimIndent(),
                formattedDateTime = "Mar 5, 10:00"
            )
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.NEXUS_10
)
@Composable
private fun MediumHomeworkTabletPreview() {
    ComposeMasterClassTheme {
        CardProject(
            project = Project(
                title = "Project X",
                description = """
                Bacon ipsum dolor amet meatloaf andouille landjaeger, turducken turkey chuck flank tongue. Alcatra chislic shankle strip steak ball tip beef venison. Doner spare ribs shank ham hock, turkey filet mignon buffalo rump cupim corned beef drumstick. Pork corned beef pig shoulder cow sausage picanha prosciutto doner beef ribs brisket bacon.
            """.trimIndent(),
                formattedDateTime = "Mar 5, 10:00"
            )
        )
    }
}

