package com.hitesh.todopod.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hitesh.todopod.ItemsViewModel
import com.hitesh.todopod.helper.DatabaseHelper
import com.hitesh.todopod.R
import com.hitesh.todopod.items

class AddNoteActivity : AppCompatActivity() {
    var editText: EditText? = null
    var saveButton: Button? = null
    var userInput: String? = null
    var itemsViewModel: ItemsViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        editText = findViewById<View>(R.id.editText) as EditText
        saveButton = findViewById<View>(R.id.saveButton) as Button
        itemsViewModel = ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory(application))
                .get(ItemsViewModel::class.java)
    }

    fun saveNote(view: View?) {
        userInput = editText?.text.toString()
        val input = items("" + userInput, "", 0)
        itemsViewModel?.insert(input)
        val mainActivity = Intent(applicationContext, MainActivity::class.java)
        startActivity(mainActivity)
    }
}