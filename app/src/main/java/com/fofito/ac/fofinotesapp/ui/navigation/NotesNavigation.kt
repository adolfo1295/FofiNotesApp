package com.fofito.ac.fofinotesapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fofito.ac.fofinotesapp.ui.categories.CategoriesScreen
import com.fofito.ac.fofinotesapp.ui.categories.addcategory.AddCategoryScreen
import com.fofito.ac.fofinotesapp.ui.notes.AddNoteScreen
import com.fofito.ac.fofinotesapp.ui.profile.ProfileScreen

@Composable
fun NotesNavigation(navController: NavHostController) {
    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        navController = navController, startDestination = Routes.CATEGORIES_SCREEN
    ) {
        composable(route = Routes.CATEGORIES_SCREEN) {
            CategoriesScreen(onAddIconClick = {
                navController.navigate(Routes.ADD_CATEGORY_SCREEN)
            }, openProfile = {
                navController.navigate(Routes.PROFILE_SCREEN)
            })
        }
        composable(route = Routes.ADD_CATEGORY_SCREEN) {
            AddCategoryScreen(onPopUp = {
                navController.navigateUp()
            })
        }
        composable(route = Routes.PROFILE_SCREEN) {
            ProfileScreen()
        }
    }
}