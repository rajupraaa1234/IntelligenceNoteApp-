package com.example.intelligencenoteapp.notes_features.domain.repository

import com.example.intelligencenoteapp.notes_features.data.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes() : Flow<List<Note>>

    suspend fun getNoteById(id:Int) : Note?

    suspend fun insertNote(note:Note)

    suspend fun deleteNote(note:Note)
}