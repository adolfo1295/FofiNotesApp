package com.fofito.ac.fofinotesapp.data.local.entities.notes

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.fofito.ac.fofinotesapp.domain.typeconverter.AppConverters
import java.time.ZonedDateTime

@Entity
@TypeConverters(AppConverters::class)
data class NoteEntity(
    @PrimaryKey(autoGenerate = false)
    val categoryName: String,
    val title: String,
    val content: String,
    val isReminder: Boolean,
    val creationTime: ZonedDateTime? = null,
    val alarmTime: ZonedDateTime? = null,
    val color: String? = null,
    val isPriority: Boolean
)
