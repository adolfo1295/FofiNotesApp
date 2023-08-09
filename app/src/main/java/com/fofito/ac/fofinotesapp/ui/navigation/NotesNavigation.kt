package com.fofito.ac.fofinotesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fofito.ac.fofinotesapp.ui.notes.CategoriesScreen
import com.fofito.ac.fofinotesapp.ui.notes.addcategory.AddCategoryScreen

@Composable
fun NotesNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.CATEGORIES_SCREEN) {
        composable(route = Routes.CATEGORIES_SCREEN) {
            CategoriesScreen(onAddIconClick = {
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