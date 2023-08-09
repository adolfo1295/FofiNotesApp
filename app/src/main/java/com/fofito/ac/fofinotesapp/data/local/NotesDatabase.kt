package com.fofito.ac.fofinotesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fofito.ac.fofinotesapp.data.local.dao.CategoryDao
import com.fofito.ac.fofinotesapp.data.local.entities.categories.CategoryEntity
import com.fofito.ac.fofinotesapp.data.local.entities.notes.NoteEntity
import com.fofito.ac.fofinotesapp.domain.typeconverter.AppConverters

@Database(
    entities = [CategoryEntity::class, NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun categoriesDao(): CategoryDao
}