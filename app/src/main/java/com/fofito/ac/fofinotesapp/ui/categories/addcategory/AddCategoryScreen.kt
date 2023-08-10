package com.fofito.ac.fofinotesapp.ui.categories.addcategory

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddCategoryScreen(onPopUp: () -> Unit) {
    val viewModel: AddCategoryViewModel = hiltViewModel()
    AddCategoryContent(viewModel = viewModel, onPopUp = onPopUp)
}