@file:OptIn(ExperimentalMaterial3Api::class)

package com.fofito.ac.fofinotesapp.ui.categories.content

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fofito.ac.fofinotesapp.data.local.entities.relations.CategoryWithNotes
import com.fofito.ac.fofinotesapp.domain.startOffsetForPage
import com.fofito.ac.fofinotesapp.ui.categories.content.components.CategoryItem
import com.fofito.ac.fofinotesapp.ui.categories.content.components.EmptyCategoriesComponent
import com.fofito.ac.fofinotesapp.ui.categories.content.components.Indicator
import com.fofito.ac.fofinotesapp.ui.categories.content.components.NotesTopAppBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoriesScreenContent(
    categories: List<CategoryWithNotes>,
    onAddCategory: () -> Unit,
    openProfile: () -> Unit
) {

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        topBar = {
            NotesTopAppBar(onAddIconClick = onAddCategory, openProfile = openProfile)
        }
    ) { paddingValues ->

        val context = LocalContext.current

        val pagerState = rememberPagerState(initialPage = 0)

        if (categories.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    HorizontalPager(
                        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 30.dp),
                        pageSpacing = 16.dp,
                        state = pagerState,
                        pageCount = categories.count()
                    ) { page ->
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.graphicsLayer {
                                val startOffset = pagerState.startOffsetForPage(page)
                                translationX = size.width * (startOffset * .99f)

                                alpha = (2f - startOffset) / 2f
                                (startOffset * 20f).coerceAtLeast(0.1f)

                                val scale = 1f - (startOffset * .1f)
                                scaleX = scale
                                scaleY = scale
                            }
                        ) {
                            CategoryItem(
                                noteCategory = categories[page],
                                onCategoryClick = {
                                    Toast.makeText(context, "Hola", Toast.LENGTH_SHORT).show()
                                },
                            )
                        }
                    }
                    Indicator(categories = categories, pagerState = pagerState)
                }
            }
        } else {
            EmptyCategoriesComponent(
                addCategory = onAddCategory
            )
        }
    }
}