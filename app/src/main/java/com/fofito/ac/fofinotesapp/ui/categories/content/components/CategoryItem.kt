package com.fofito.ac.fofinotesapp.ui.categories.content.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fofito.ac.fofinotesapp.data.local.entities.relations.CategoryWithNotes
import com.fofito.ac.fofinotesapp.domain.mappers.toCategoryColor
import com.fofito.ac.fofinotesapp.domain.mappers.totoNoteCategoryUi
import com.fofito.ac.fofinotesapp.domain.models.NoteCategory
import com.fofito.ac.fofinotesapp.theme.theme.category_blue_0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItem(
    noteCategory: CategoryWithNotes,
    onCategoryClick: (NoteCategory) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.85f),
        colors = CardDefaults.cardColors(
            containerColor = noteCategory.category.color.toCategoryColor(),
            contentColor = Color.Black
        ),
        onClick = {
            onCategoryClick(noteCategory.category.totoNoteCategoryUi())
        }) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    text = noteCategory.category.categoryName,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                )
                AsyncImage(
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop,
                    model = noteCategory.category.imageInfo.image,
                    contentDescription = "icon"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = noteCategory.category.description,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Light,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = noteCategory.notes.count().toString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 48.sp
                    )
                    Text(
                        text = if (noteCategory.notes.count() == 1) "Nota" else "Notas",
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}