package com.fofito.ac.fofinotesapp.domain.mappers

import android.provider.ContactsContract.CommonDataKinds.Note
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

fun CategoryEntity.totoNoteCategoryUi(): NoteCategory {
    return NoteCategory(
        color = this.color,
        name = this.categoryName,
        description = this.description,
        imageInfo = this.imageInfo
    )
}