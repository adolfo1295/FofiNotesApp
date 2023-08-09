package com.fofito.ac.fofinotesapp.domain.usecase.addcategory

import com.fofito.ac.fofinotesapp.domain.mappers.toCategoryEntity
import com.fofito.ac.fofinotesapp.domain.models.NoteCategory
import com.fofito.ac.fofinotesapp.domain.repositories.CategoryRepository
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {

    suspend operator fun invoke(noteCategory: NoteCategory) {
        repository.addCategory(noteCategory.toCategoryEntity())
    }
}