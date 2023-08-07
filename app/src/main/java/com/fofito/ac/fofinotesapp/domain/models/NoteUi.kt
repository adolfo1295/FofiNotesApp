package com.fofito.ac.fofinotesapp.domain.models

import java.time.ZonedDateTime

data class NoteUi(
    val id: Int,
    val title: String,
    val content: String,
    val isReminder: Boolean,
    val creationTime: ZonedDateTime? = null,
    val alarmTime: ZonedDateTime? = null,
    val color: String? = null,
    val isPriority: Boolean
)
