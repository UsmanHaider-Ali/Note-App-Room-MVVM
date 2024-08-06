package com.example.noteappwithroom.repositories

import com.example.noteappwithroom.database.NoteDatabase
import com.example.noteappwithroom.models.Note

class NoteRepository(private val noteDatabase: NoteDatabase) {

    suspend fun insertNote(note: Note) = noteDatabase.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note) = noteDatabase.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = noteDatabase.getNoteDao().deleteNote(note)

    fun getAllNotes() = noteDatabase.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = noteDatabase.getNoteDao().searchNote(query)

}