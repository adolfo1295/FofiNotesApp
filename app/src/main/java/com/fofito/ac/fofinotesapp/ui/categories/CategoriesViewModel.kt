package com.fofito.ac.fofinotesapp.ui.categories

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fofito.ac.fofinotesapp.data.local.entities.relations.CategoryWithNotes
import com.fofito.ac.fofinotesapp.domain.repositories.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    private var _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.value = UiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotesByCategory()
                .catch { error ->
                    _uiState.update { it.copy(loading = false, categories = emptyList()) }
                }
                .collect { categoryWithNotes ->
                    _uiState.update {
                        it.copy(
                            categories = categoryWithNotes,
                            loading = false
                        )
                    }
                }
        }
    }

}

data class UiState(
    val loading: Boolean = false,
    val categories: List<CategoryWithNotes> = emptyList()
)