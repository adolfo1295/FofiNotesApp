package com.fofito.ac.fofinotesapp.ui.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddNoteScreen() {

    val viewModel: AddNoteViewModel = hiltViewModel()
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Notes!")
    }

}