package com.fofito.ac.fofinotesapp.ui.notes

import androidx.compose.runtime.Composable
import com.fofito.ac.fofinotesapp.R
import com.fofito.ac.fofinotesapp.domain.models.ImageCategory
import com.fofito.ac.fofinotesapp.domain.models.NoteCategory
import com.fofito.ac.fofinotesapp.domain.models.NoteUi
import com.fofito.ac.fofinotesapp.ui.notes.content.NotesScreenContent

@Composable
fun NotesScreen(onAddIconClick: () -> Unit) {
    val dummyList = arrayListOf(
        NoteUi(
            id = 0,
            title = "Mi primer nota",
            content = "Contenido de mi primer nota",
            isReminder = true,
            isPriority = true,
        ),
        NoteUi(
            id = 1,
            title = "Mi segunda nota",
            content = "Contenido de mi segunda nota",
            isReminder = false,
            isPriority = false,
        )
    )

    val notesCategories = arrayListOf(
        NoteCategory(
            id = 0,
            name = "Notas personales",
            description = "Este espacio es para notas personales",
            imageInfo = ImageCategory(id = 0, image = R.drawable.category_motivation)
        ),
        NoteCategory(
            id = 1,
            name = "Morning pages",
            description = "Este espacio es para morning pages",
            imageInfo = ImageCategory(id = 0, image = R.drawable.category_plants)
        ),
        NoteCategory(
            id = 2,
            name = "Corto plazo",
            description = "Este espacio es para metas a corto plazo",
            imageInfo = ImageCategory(id = 0, image = R.drawable.category_study)
        ),
        NoteCategory(
            id = 3,
            name = "Largo plazo",
            description = "Este espacio es para metas a largo plazo",
            imageInfo = ImageCategory(id = 0, image = R.drawable.category_long_period)
        ),
        NoteCategory(
            id = 4,
            name = "Metas de año nuevo",
            description = "Este espacio es para metas de año nuevo",
            imageInfo = ImageCategory(id = 0, image = R.drawable.category_short_period)
        ),
    )
    NotesScreenContent(
        notes = dummyList,
        categories = notesCategories,
        onAddIconClick = onAddIconClick
    )
}