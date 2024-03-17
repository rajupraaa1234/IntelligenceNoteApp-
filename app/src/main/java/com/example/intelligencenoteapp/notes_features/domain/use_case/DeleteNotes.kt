package com.example.intelligencenoteapp.notes_features.domain.use_case

import com.example.intelligencenoteapp.notes_features.data.domain.model.Note
import com.example.intelligencenoteapp.notes_features.domain.repository.NoteRepository

class DeleteNotes(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}