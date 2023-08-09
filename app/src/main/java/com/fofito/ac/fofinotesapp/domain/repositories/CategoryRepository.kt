package com.fofito.ac.fofinotesapp.domain.repositories

import com.fofito.ac.fofinotesapp.data.local.entities.categories.CategoryEntity
import com.fofito.ac.fofinotesapp.data.local.entities.relations.CategoryWithNotes
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun addCategory(categoryEntity: CategoryEntity)
    suspend fun deleteCategory(categoryEntity: CategoryEntity)
    fun getAllCategories(): Flow<List<CategoryEntity>>
    fun getAllNotesByCategory(categoryName: String): Flow<List<CategoryWithNotes>>

}