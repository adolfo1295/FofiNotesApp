package com.fofito.ac.fofinotesapp.data.local.entities.categories

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.fofito.ac.fofinotesapp.domain.models.ImageCategory
import com.fofito.ac.fofinotesapp.domain.typeconverter.AppConverters

@Entity
@TypeConverters(AppConverters::class)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val categoryName: String,
    val description: String,
    val color: String,
    val imageInfo: ImageCategory
)
