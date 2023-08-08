package com.fofito.ac.fofinotesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fofito.ac.fofinotesapp.data.local.dao.CategoryDao
import com.fofito.ac.fofinotesapp.data.local.entities.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun categoriesDao(): CategoryDao
}