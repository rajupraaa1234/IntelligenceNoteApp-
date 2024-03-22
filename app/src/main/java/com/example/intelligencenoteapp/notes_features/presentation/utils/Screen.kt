package com.example.intelligencenoteapp.notes_features.presentation.utils

sealed class Screen(val route : String) {
    object NotesScreen : Screen("note_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")

}