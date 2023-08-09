package com.fofito.ac.fofinotesapp.domain.mappers

import androidx.compose.ui.graphics.Color
import com.fofito.ac.fofinotesapp.theme.theme.blue_fancy
import com.fofito.ac.fofinotesapp.theme.theme.category_blue_0
import com.fofito.ac.fofinotesapp.theme.theme.category_blue_1
import com.fofito.ac.fofinotesapp.theme.theme.category_blue_2
import com.fofito.ac.fofinotesapp.theme.theme.category_blue_3
import com.fofito.ac.fofinotesapp.theme.theme.category_blue_4
import com.fofito.ac.fofinotesapp.theme.theme.green_fancy
import com.fofito.ac.fofinotesapp.theme.theme.pink_fancy
import com.fofito.ac.fofinotesapp.theme.theme.sky_fancy
import com.fofito.ac.fofinotesapp.theme.theme.yellow_fancy
import com.fofito.ac.fofinotesapp.utils.CategoryColorConstants.BLUE_0
import com.fofito.ac.fofinotesapp.utils.CategoryColorConstants.BLUE_1
import com.fofito.ac.fofinotesapp.utils.CategoryColorConstants.BLUE_2
import com.fofito.ac.fofinotesapp.utils.CategoryColorConstants.BLUE_3
import com.fofito.ac.fofinotesapp.utils.CategoryColorConstants.BLUE_4
import com.fofito.ac.fofinotesapp.utils.ColorConstants.BLUE
import com.fofito.ac.fofinotesapp.utils.ColorConstants.GREEN
import com.fofito.ac.fofinotesapp.utils.ColorConstants.PINK
import com.fofito.ac.fofinotesapp.utils.ColorConstants.SKY
import com.fofito.ac.fofinotesapp.utils.ColorConstants.YELLOW
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun String.toNoteColor(): Color {
    return when (this) {
        BLUE -> {
            blue_fancy
        }

        GREEN -> {
            green_fancy
        }

        YELLOW -> {
            yellow_fancy
        }

        PINK -> {
            pink_fancy
        }

        SKY -> {
            sky_fancy
        }

        else -> {
            sky_fancy
        }
    }
}

fun String.toCategoryColor(): Color {
    return when (this) {
        BLUE_0 -> {
            category_blue_0
        }

        BLUE_1 -> {
            category_blue_1
        }

        BLUE_2 -> {
            category_blue_2
        }

        BLUE_3 -> {
            category_blue_3
        }

        BLUE_4 -> {
            category_blue_4
        }

        else -> {
            category_blue_0
        }
    }
}

inline fun <reified T> Gson.fromJson(json: String) =
    fromJson<T>(json, object : TypeToken<T>() {}.type)