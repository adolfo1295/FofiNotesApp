@file:OptIn(ExperimentalFoundationApi::class)

package com.fofito.ac.fofinotesapp.ui.notes.content.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fofito.ac.fofinotesapp.domain.models.NoteCategory
import java.util.Locale.Category

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Indicator(
    categories: List<NoteCategory>,
    pagerState: PagerState
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.Center)) {
            repeat(categories.count()) { position ->
                Box(
                    modifier = Modifier
                        .width(if (pagerState.currentPage == position) 25.dp else 10.dp)
                        .height(3.dp)
                        .background(
                            if (pagerState.currentPage == position) Color.White else Color.White.copy(
                                alpha = 0.5f
                            )
                        )
                        .clip(RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorPreview() {
    val notesCategories = arrayListOf<NoteCategory>(
        NoteCategory(
            id = 0,
            name = "Notas personales",
            description = "Este espacio es para notas personales"
        ),
        NoteCategory(
            id = 1,
            name = "Morning pages",
            description = "Este espacio es para morning pages"
        ),
        NoteCategory(
            id = 2,
            name = "Corto plazo",
            description = "Este espacio es para metas a corto plazo"
        ),
        NoteCategory(
            id = 3,
            name = "Largo plazo",
            description = "Este espacio es para metas a largo plazo"
        ),
        NoteCategory(
            id = 4,
            name = "Metas de año nuevo",
            description = "Este espacio es para metas de año nuevo"
        ),
    )
    val pagerState = rememberPagerState(pageCount = { notesCategories.count() })
    Indicator(categories = notesCategories, pagerState = pagerState)
}