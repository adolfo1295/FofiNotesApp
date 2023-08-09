package com.fofito.ac.fofinotesapp.domain.mappers

import com.fofito.ac.fofinotesapp.data.local.entities.categories.CategoryEntity
import com.fofito.ac.fofinotesapp.domain.models.ImageCategory
import com.fofito.ac.fofinotesapp.domain.models.NoteCategory

fun NoteCategory.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        color = this.color ?: "#000000",
        categoryName = this.name,
        description = this.description,
        imageInfo = this.imageInfo ?: ImageCategory(0, 0, false)
    )
}