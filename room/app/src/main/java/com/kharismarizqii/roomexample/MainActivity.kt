package com.kharismarizqii.roomexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.kharismarizqii.roomexample.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        val NEW_NOTE_ACTIVITY_REQUEST_CODE = 1
    }
    private lateinit var model: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatBtn.setOnClickListener {
            Intent(this@MainActivity, NewNoteActivity::class.java).also {
                startActivityForResult(it, NEW_NOTE_ACTIVITY_REQUEST_CODE)
            }
        }

        model = ViewModelProviders.of(this).get(NoteViewModel::class.java)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val noteId = UUID.randomUUID().toString()
            val note = data?.getStringExtra(NewNoteActivity.NOTE_ADDED)?.let {
                Note(
                    noteId,
                    it
                )
            }
            if (note != null) {
                model.insert(note)
            }
            toast("Note is Saved")
        } else{
            toast("Note is not saved")
        }
    }
}
