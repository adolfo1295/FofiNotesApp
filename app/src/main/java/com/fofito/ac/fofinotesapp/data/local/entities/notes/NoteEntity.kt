package com.fofito.ac.fofinotesapp.data.local.entities.notes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    val noteCategoryName: String,
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val content: String,
    val isReminder: Boolean,
    val creationTime: String,
    val alarmTime: String,
    val color: String,
    val isPriority: Boolean
)
