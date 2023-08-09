package com.fofito.ac.fofinotesapp.ui.notes

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.fofito.ac.fofinotesapp.ui.notes.content.CategoriesScreenContent

@Composable
fun CategoriesScreen(onAddIconClick: () -> Unit) {

    val viewModel: CategoriesViewModel = hiltViewModel()

    CategoriesScreenContent(
        categories = emptyList(),
        onAddCategory = onAddIconClick
    )
}