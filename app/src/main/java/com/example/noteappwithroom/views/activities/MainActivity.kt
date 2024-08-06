package com.example.noteappwithroom.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.noteappwithroom.R
import com.example.noteappwithroom.database.NoteDatabase
import com.example.noteappwithroom.repositories.NoteRepository
import com.example.noteappwithroom.viewmodels.NoteViewModel
import com.example.noteappwithroom.viewmodels.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()

    }

    private fun setupViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val noteViewModelFactory =
            NoteViewModelFactory(application = application, noteRepository = noteRepository)
        noteViewModel = ViewModelProvider(this, noteViewModelFactory)[NoteViewModel::class.java]

    }
}