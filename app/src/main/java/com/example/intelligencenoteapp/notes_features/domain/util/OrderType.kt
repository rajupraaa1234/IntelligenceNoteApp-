package com.example.intelligencenoteapp.notes_features.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}