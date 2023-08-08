package com.fofito.ac.fofinotesapp.data.repositories

import com.fofito.ac.fofinotesapp.data.local.dao.CategoryDao
import com.fofito.ac.fofinotesapp.data.local.entities.CategoryEntity
import com.fofito.ac.fofinotesapp.domain.repositories.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    dao: CategoryDao
) : CategoryRepository {
    override suspend fun addCategory(categoryEntity: CategoryEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategory(categoryEntity: CategoryEntity) {
        TODO("Not yet implemented")
    }

    override fun getAllCategories(): Flow<List<CategoryEntity>> {
        TODO("Not yet implemented")
    }


}