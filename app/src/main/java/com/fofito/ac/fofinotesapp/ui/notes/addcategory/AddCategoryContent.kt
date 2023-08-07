@file:OptIn(ExperimentalComposeUiApi::class)

package com.fofito.ac.fofinotesapp.ui.notes.addcategory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fofito.ac.fofinotesapp.R
import com.fofito.ac.fofinotesapp.ui.notes.addcategory.components.ImageCategoryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCategoryContent(viewModel: AddCategoryViewModel, onPopUp: () -> Unit) {

    val addCategoryUiState by viewModel.addCategoryUiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(MaterialTheme.colorScheme.surface),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onPopUp) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                title = {
                    Text(text = "Detalles de la categoria")
                })
        },
        floatingActionButton = {
            if (addCategoryUiState.name.isNotEmpty() && addCategoryUiState.description.isNotEmpty()) {
                FloatingActionButton(
                    onClick = {
                        viewModel.addCategory(
                            addCategoryUiState.name,
                            addCategoryUiState.description,
                            addCategoryUiState.selectedImage
                        )
                    }) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = stringResource(R.string.done)
                    )
                }
            }
        }
    ) { paddingValues ->
        val focusManager = LocalFocusManager.current
        val kc = LocalSoftwareKeyboardController.current
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 10.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.titleLarge,
                    text = "Nombre"
                )
                OutlinedTextField(
                    shape = RoundedCornerShape(10.dp),
                    label = { Text(text = stringResource(R.string.add_category_name)) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }),
                    value = addCategoryUiState.name, onValueChange = { newValue ->
                        viewModel.updateCategoryName(newValue)
                    })
                Text(
                    modifier = Modifier.padding(top = 10.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.titleLarge,
                    text = "Descripcion"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    label = { Text(text = stringResource(R.string.add_category_description)) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        kc?.hide()
                    }),
                    maxLines = 10,
                    value = addCategoryUiState.description, onValueChange = { newValue ->
                        viewModel.updateCategoryDescription(newValue)
                    })
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(top = 10.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.titleLarge,
                    text = "Imagen"
                )
                Spacer(modifier = Modifier.height(5.dp))
                var selectedIndex by remember {
                    mutableIntStateOf(0)
                }
                LazyRow(
                    modifier = Modifier.selectableGroup()
                ) {
                    itemsIndexed(viewModel.options) { index, imageCategory ->
                        ImageCategoryItem(
                            imageCategory = imageCategory,
                            onCategorySelected = {
                                selectedIndex = if (selectedIndex == index) -1 else index
                                viewModel.updateImage(imageCategory)
                            },
                            selectedIndex = selectedIndex,
                            index = index
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddCategoryContentPreview() {
    /*    AddCategoryContent()*/
}