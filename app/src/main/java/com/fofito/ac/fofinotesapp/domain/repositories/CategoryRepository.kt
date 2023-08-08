package com.fofito.ac.fofinotesapp.domain.repositories

import com.fofito.ac.fofinotesapp.data.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun addCategory(categoryEntity: CategoryEntity)
    suspend fun deleteCategory(categoryEntity: CategoryEntity)
    fun getAllCategories(): Flow<List<CategoryEntity>>

}