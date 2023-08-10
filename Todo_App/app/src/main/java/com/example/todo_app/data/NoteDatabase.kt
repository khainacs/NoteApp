package com.example.todo_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todo_app.model.Note
import com.example.todo_app.util.DateConvert
import com.example.todo_app.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConvert::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
   abstract fun noteDao(): NoteDatabaseDao
}