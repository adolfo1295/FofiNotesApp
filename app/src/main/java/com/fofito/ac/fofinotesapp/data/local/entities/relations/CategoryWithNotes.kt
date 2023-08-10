package com.fofito.ac.fofinotesapp.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.TypeConverters
import com.fofito.ac.fofinotesapp.data.local.entities.categories.CategoryEntity
import com.fofito.ac.fofinotesapp.data.local.entities.notes.NoteEntity
import com.fofito.ac.fofinotesapp.domain.typeconverter.AppConverters

data class CategoryWithNotes(
    @TypeConverters(AppConverters::class)
    @Embedded val category: CategoryEntity,
    @Relation(
        parentColumn = "categoryName",
        entityColumn = "noteCategoryName"
    )
    val notes: List<NoteEntity>
)
