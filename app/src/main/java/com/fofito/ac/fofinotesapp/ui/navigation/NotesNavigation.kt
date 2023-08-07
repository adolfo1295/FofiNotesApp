package com.fofito.ac.fofinotesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fofito.ac.fofinotesapp.ui.notes.NotesScreen
import com.fofito.ac.fofinotesapp.ui.notes.addcategory.AddCategoryScreen

@Composable
fun NotesNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.NOTES_SCREEN) {
        composable(route = Routes.NOTES_SCREEN) {
            NotesScreen(onAddIconClick = {
                navController.navigate(Routes.ADD_CATEGORY_SCREEN)
            })
        }
        composable(route = Routes.ADD_CATEGORY_SCREEN) {
            AddCategoryScreen(onPopUp = {
                navController.navigateUp()
            })
        }
    }
}