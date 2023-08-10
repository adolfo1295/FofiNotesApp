package com.fofito.ac.fofinotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.fofito.ac.fofinotesapp.theme.theme.FofiNotesAppTheme
import com.fofito.ac.fofinotesapp.ui.navigation.NotesNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FofiNotesAppTheme {
                val navController = rememberNavController()
                NotesNavigation(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FofiNotesAppTheme {

    }
}