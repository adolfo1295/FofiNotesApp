package com.fofito.ac.fofinotesapp.ui.notes.content.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fofito.ac.fofinotesapp.domain.mappers.toNoteColor
import com.fofito.ac.fofinotesapp.domain.models.NoteUi
import com.fofito.ac.fofinotesapp.theme.theme.sky_fancy
import com.fofito.ac.fofinotesapp.theme.theme.yellow_fancy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrincipalNoteUiItem(noteUi: NoteUi, onNoteClick: (NoteUi) -> Unit) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = noteUi.color?.toNoteColor() ?: yellow_fancy,
            contentColor = Color.Black,
        ),
        onClick = {
            onNoteClick(noteUi)
        },
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .padding(8.dp)
    ) {
        Box {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    style = MaterialTheme.typography.titleSmall,
                    text = noteUi.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    style = MaterialTheme.typography.bodySmall,
                    text = noteUi.content,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4
                )
            }
        }
    }
}
