package com.example.intelligencenoteapp.notes_features.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intelligencenoteapp.notes_features.data.domain.model.Note
import com.example.intelligencenoteapp.notes_features.domain.use_case.NoteUseCases
import com.example.intelligencenoteapp.notes_features.domain.util.NoteOrder
import com.example.intelligencenoteapp.notes_features.domain.util.OrderType
import com.example.intelligencenoteapp.notes_features.presentation.utils.NotesEvent
import com.example.intelligencenoteapp.notes_features.presentation.utils.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state
    private var recentDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNewOrderNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentDeletedNote ?: return@launch)
                    recentDeletedNote = null
                }
            }

            is NotesEvent.DeleteNode -> {
                viewModelScope.launch {
                    noteUseCases.deleteNotes(event.note)
                    recentDeletedNote = event.note
                }
            }

            is NotesEvent.Order -> {
                if (_state.value.noteOrder::class == event.noteOrder::class && _state.value.noteOrder.orderType == event.noteOrder.orderType) {
                    return
                }
                getNewOrderNotes(event.noteOrder)
            }

            is NotesEvent.ToggleOrderSection -> {
                _state.value = _state.value.copy(
                    isOrderSectionVisible = !_state.value.isOrderSectionVisible
                )
            }
        }

    }

    private fun getNewOrderNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(noteOrder).onEach { notes ->
            _state.value = _state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }
            .launchIn(viewModelScope)
    }


}