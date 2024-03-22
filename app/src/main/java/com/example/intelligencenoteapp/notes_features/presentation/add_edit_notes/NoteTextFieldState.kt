package com.example.intelligencenoteapp.notes_features.presentation.add_edit_notes

data class NoteTextFieldState(
    val text : String = "",
    val hint : String = "",
    val isHintVisible : Boolean = true
)
