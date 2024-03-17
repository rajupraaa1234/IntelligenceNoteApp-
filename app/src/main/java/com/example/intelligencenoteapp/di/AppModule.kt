package com.example.intelligencenoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.intelligencenoteapp.notes_features.data.data_source.NoteDataBase
import com.example.intelligencenoteapp.notes_features.data.repository.NoteRepositoryImpl
import com.example.intelligencenoteapp.notes_features.domain.repository.NoteRepository
import com.example.intelligencenoteapp.notes_features.domain.use_case.AddNote
import com.example.intelligencenoteapp.notes_features.domain.use_case.DeleteNotes
import com.example.intelligencenoteapp.notes_features.domain.use_case.GetNotes
import com.example.intelligencenoteapp.notes_features.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideNoteDatabase(app : Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDataBase): NoteRepositoryImpl {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository) : NoteUseCases{
        return NoteUseCases(getNotes = GetNotes(noteRepository), deleteNotes = DeleteNotes(noteRepository), addNote = AddNote(noteRepository))
    }
}
