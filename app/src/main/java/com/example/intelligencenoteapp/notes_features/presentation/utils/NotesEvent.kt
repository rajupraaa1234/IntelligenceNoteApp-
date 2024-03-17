package com.example.intelligencenoteapp.notes_features.presentation.utils

import com.example.intelligencenoteapp.notes_features.data.domain.model.Note
import com.example.intelligencenoteapp.notes_features.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNode(val note: Note) : NotesEvent()
    object RestoreNote:NotesEvent()
    object ToggleOrderSection:NotesEvent()

}