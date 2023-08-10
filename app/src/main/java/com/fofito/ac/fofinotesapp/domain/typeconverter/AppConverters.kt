package com.fofito.ac.fofinotesapp.domain.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.fofito.ac.fofinotesapp.domain.mappers.fromJson
import com.fofito.ac.fofinotesapp.domain.models.ImageCategory
import com.fofito.ac.fofinotesapp.domain.models.NoteUi
import com.google.gson.Gson
import java.time.ZonedDateTime

@ProvidedTypeConverter
class AppConverters {

    @TypeConverter
    fun fromImageCategoryToString(imageCategory: ImageCategory): String {
        return Gson().toJson(imageCategory)
    }

    @TypeConverter
    fun toImageCategory(value: String): ImageCategory {
        return try {
            Gson().fromJson<ImageCategory>(value)
        } catch (e: Exception) {
            ImageCategory(0, 0, false)
        }
    }
}
