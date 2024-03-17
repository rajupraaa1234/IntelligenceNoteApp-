package com.example.intelligencenoteapp.notes_features.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    class Tittle(orderType: OrderType): NoteOrder(orderType)
    class Color(orderType: OrderType): NoteOrder(orderType)
    class Date(orderType: OrderType): NoteOrder(orderType)
}