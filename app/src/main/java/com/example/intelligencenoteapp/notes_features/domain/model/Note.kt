package com.example.intelligencenoteapp.notes_features.data.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.PropertyKey

@Entity
data class Note(
    val title: String,
    val content:String,
    val timestamp : Long,
    val color : Int,
    @PrimaryKey val id : Int?=null
){
    companion object {
        val noteColors = listOf(Color.Red, Color.Cyan, Color.Yellow,Color.Blue, Color.Gray,
            Color.Green
        )
    }
}
