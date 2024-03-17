package com.example.intelligencenoteapp.notes_features.presentation.utils

import com.example.intelligencenoteapp.notes_features.data.domain.model.Note
import com.example.intelligencenoteapp.notes_features.domain.util.NoteOrder
import com.example.intelligencenoteapp.notes_features.domain.util.OrderType

data class NotesState(
    val notes : List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
