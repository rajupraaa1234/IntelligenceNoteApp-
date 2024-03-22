package com.example.intelligencenoteapp.notes_features.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNotes: DeleteNotes,
    val addNote: AddNote,
    val getNote : GetNote
)
