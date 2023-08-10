package com.fofito.ac.fofinotesapp.ui.categories.addcategory.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fofito.ac.fofinotesapp.R
import com.fofito.ac.fofinotesapp.domain.models.ImageCategory

@Composable
fun ImageCategoryItem(
    imageCategory: ImageCategory,
    onCategorySelected: (ImageCategory) -> Unit,
    selectedIndex: Int,
    index: Int,
) {
    Card(
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = if (selectedIndex == index)
                MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = Modifier
            .selectable(selected = selectedIndex == index,
                onClick = {
                    onCategorySelected(imageCategory)
                })
            .padding(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop,
            model = imageCategory.image,
            contentDescription = stringResource(id = R.string.done)
        )
    }
}