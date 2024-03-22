package com.example.intelligencenoteapp.notes_features.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.intelligencenoteapp.notes_features.domain.util.NoteOrder
import com.example.intelligencenoteapp.notes_features.domain.util.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier, noteOrder: NoteOrder, onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Title", selected =noteOrder is NoteOrder.Tittle, onSelect = { onOrderChange(NoteOrder.Tittle(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Date", selected =noteOrder is NoteOrder.Date, onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Color", selected =noteOrder is NoteOrder.Color, onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) })
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Ascending",
                selected =noteOrder.orderType is OrderType.Ascending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Ascending))
                })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Descending",
                selected =noteOrder.orderType is OrderType.Descending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Descending))
                })
        }
    }
}