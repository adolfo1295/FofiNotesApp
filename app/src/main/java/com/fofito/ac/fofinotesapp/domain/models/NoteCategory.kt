package com.fofito.ac.fofinotesapp.domain.models

data class NoteCategory(
    val name: String,
    val description: String,
    val color: String? = null,
    val notes: List<NoteUi> = emptyList(),
    val imageInfo: ImageCategory? = null
)
