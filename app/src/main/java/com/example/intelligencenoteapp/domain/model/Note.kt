package com.example.intelligencenoteapp.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.PrimaryKey
import javax.annotation.PropertyKey

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
