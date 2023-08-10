package com.fofito.ac.fofinotesapp.ui.categories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fofito.ac.fofinotesapp.ui.categories.content.CategoriesScreenContent

@Composable
fun CategoriesScreen(onAddIconClick: () -> Unit, openProfile: () -> Unit) {

    val viewModel: CategoriesViewModel = hiltViewModel()

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    if (state.loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                color = Color.Magenta,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else {
        CategoriesScreenContent(
            categories = state.categories,
            onAddCategory = onAddIconClick,
            openProfile = openProfile
        )
    }
}