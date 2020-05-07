package com.kharismarizqii.roomexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNoteActivity : AppCompatActivity() {

    companion object{
        val NOTE_ADDED = "new_note"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        btn_save.setOnClickListener {
            val resultIntent = Intent()
            if (TextUtils.isEmpty(et_note.text)){
                setResult(Activity.RESULT_CANCELED, resultIntent)
            }else{
                val note = et_note.text.toString()
                resultIntent.putExtra(NOTE_ADDED, note)
                setResult(Activity.RESULT_OK, resultIntent)
            }
            finish()
        }
    }
}
