package com.fofito.ac.fofinotesapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fofito.ac.fofinotesapp.domain.models.ImageCategory
import com.fofito.ac.fofinotesapp.domain.models.NoteUi

@Entity
data class CategoryEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val color: String,
    val notes: List<NoteUi> = emptyList(),
    val imageInfo: ImageCategory
)
