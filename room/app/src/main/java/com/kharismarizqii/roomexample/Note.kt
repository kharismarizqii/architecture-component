package com.kharismarizqii.roomexample

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    @NonNull
    var id: String,

    @NonNull
    @ColumnInfo(name ="note")
    var mNote: String
)