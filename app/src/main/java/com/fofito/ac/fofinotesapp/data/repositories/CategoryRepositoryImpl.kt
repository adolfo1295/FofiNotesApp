package com.fofito.ac.fofinotesapp.data.repositories

import com.fofito.ac.fofinotesapp.data.local.dao.CategoryDao
import com.fofito.ac.fofinotesapp.data.local.entities.categories.CategoryEntity
import com.fofito.ac.fofinotesapp.data.local.entities.relations.CategoryWithNotes
import com.fofito.ac.fofinotesapp.domain.repositories.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val dao: CategoryDao
) : CategoryRepository {
    override suspend fun addCategory(categoryEntity: CategoryEntity) {
        dao.upsertCategory(categoryEntity)
    }

    override suspend fun deleteCategory(categoryEntity: CategoryEntity) {
        dao.deleteCategory(categoryEntity)
    }

    override fun getAllCategories(): Flow<List<CategoryEntity>> {
        return dao.getAllCategories()
    }

    override fun getAllNotesByCategory(categoryName: String): Flow<List<CategoryWithNotes>> {
        TODO()
    }
}
