package com.example.intelligencenoteapp.notes_features.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.intelligencenoteapp.notes_features.data.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase : RoomDatabase(){
    abstract val noteDao : NoteDao
}