package com.fofito.ac.fofinotesapp.ui.categories.addcategory

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fofito.ac.fofinotesapp.R
import com.fofito.ac.fofinotesapp.domain.models.ImageCategory
import com.fofito.ac.fofinotesapp.domain.models.NoteCategory
import com.fofito.ac.fofinotesapp.domain.usecase.addcategory.AddCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    val addCategoryUseCase: AddCategoryUseCase
) : ViewModel() {

    private var _addCategoryUiState = MutableStateFlow(AddCategoryUiState())
    val addCategoryUiState = _addCategoryUiState.asStateFlow()

    fun updateCategoryName(newValue: String) {
        _addCategoryUiState.update { it.copy(name = newValue) }
    }

    fun updateCategoryDescription(newValue: String) {
        _addCategoryUiState.update { it.copy(description = newValue) }
    }

    fun updateImage(newValue: ImageCategory) {
        _addCategoryUiState.update { it.copy(selectedImage = newValue) }
    }

    fun addCategory(name: String, description: String, imageCategory: ImageCategory? = null) {
        viewModelScope.launch {
            addCategoryUseCase(
                NoteCategory(
                    name = name,
                    description = description,
                    imageInfo = imageCategory
                )
            )
            _addCategoryUiState.update { it.copy(onSuccess = true) }
        }
    }

    private val _imageCategories = listOf(
        ImageCategory(id = 0, image = R.drawable.category_success, isSelected = false),
        ImageCategory(id = 1, image = R.drawable.category_plants, isSelected = false),
        ImageCategory(id = 2, image = R.drawable.category_relax, isSelected = false),
        ImageCategory(id = 3, image = R.drawable.category_motivation, isSelected = false),
        ImageCategory(id = 4, image = R.drawable.category_study, isSelected = false),
        ImageCategory(id = 5, image = R.drawable.category_short_period, isSelected = false),
        ImageCategory(id = 6, image = R.drawable.category_long_period, isSelected = false),
        ImageCategory(id = 7, image = R.drawable.category_morning_pages, isSelected = false),
    ).toMutableStateList()
    val imageCategories: List<ImageCategory>
        get() = _imageCategories
}

data class AddCategoryUiState(
    val name: String = "",
    val description: String = "",
    val selectedImage: ImageCategory? = null,
    val onSuccess: Boolean = false
)