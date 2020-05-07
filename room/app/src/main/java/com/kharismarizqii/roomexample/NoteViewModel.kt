package com.kharismarizqii.roomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application){
    private lateinit var noteDao: NoteDao
    private var noteDb: NoteRoomDatabase?

    init {
        noteDb = NoteRoomDatabase.getNoteRoomDatabase(application)
        noteDao = noteDb?.noteDao()!!
    }

    fun insert(note: Note){
        insertCoroutines(noteDao, note)
    }

    fun insertCoroutines(noteDao: NoteDao, note: Note){
        CoroutineScope(IO).launch {
            noteDao.insert(note)
        }.invokeOnCompletion {
            println("debug: $note")
        }
    }

}