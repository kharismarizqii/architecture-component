package com.kharismarizqii.roomexample

import androidx.room.Entity

@Entity(tableName = "notes")
data class Note(
    var id: String
)