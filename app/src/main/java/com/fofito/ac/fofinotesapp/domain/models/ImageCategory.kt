package com.fofito.ac.fofinotesapp.domain.models

data class ImageCategory(
    val id: Int,
    val image: Int,
    var isSelected: Boolean = false
)
