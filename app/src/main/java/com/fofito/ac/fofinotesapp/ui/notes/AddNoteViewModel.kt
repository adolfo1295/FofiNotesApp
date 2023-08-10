package com.fofito.ac.fofinotesapp.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fofito.ac.fofinotesapp.data.local.entities.notes.NoteEntity
import com.fofito.ac.fofinotesapp.domain.repositories.CategoryRepository
import com.fofito.ac.fofinotesapp.utils.ColorConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val repository: CategoryRepository
): ViewModel() {

    init {
        viewModelScope.launch {
            repository.addNote(NoteEntity(
                title = "Note 1",
                isPriority = true,
                color = ColorConstants.BLUE,
                isReminder = true,
                content = "Content",
                alarmTime = "1 Hour",
                creationTime = "10/08/2023",
                noteCategoryName = "Adolfo"
            ))
        }
    }

}