package com.fofito.ac.fofinotesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.fofito.ac.fofinotesapp.data.local.entities.categories.CategoryEntity
import com.fofito.ac.fofinotesapp.data.local.entities.notes.NoteEntity
import com.fofito.ac.fofinotesapp.data.local.entities.relations.CategoryWithNotes
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity)


    @Transaction
    @Query(
        """
        select * from categoryentity where categoryName = :categoryName 
    """
    )
    fun getCategoryWithNotes(categoryName: String): Flow<List<CategoryWithNotes>>


    @Upsert
    suspend fun upsertCategory(categoryEntity: CategoryEntity)

    @Delete
    suspend fun deleteCategory(categoryEntity: CategoryEntity)

    @Query(
        """
        select * from categoryentity
    """
    )
    fun getAllCategories(): Flow<List<CategoryEntity>>

    @Transaction
    @Query("SELECT * FROM categoryentity")
    fun getUsersWithPlaylists(): Flow<List<CategoryWithNotes>>

    @Upsert
    suspend fun addNote(noteEntity: NoteEntity)

}