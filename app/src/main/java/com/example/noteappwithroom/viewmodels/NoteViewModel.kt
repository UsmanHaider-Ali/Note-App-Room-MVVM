package com.example.noteappwithroom.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappwithroom.models.Note
import com.example.noteappwithroom.repositories.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val application: Application, val noteRepository: NoteRepository) :
    AndroidViewModel(application) {

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun getAllNotes() = noteRepository.getAllNotes()

    fun searchNote(query: String?) = noteRepository.searchNote(query)

}