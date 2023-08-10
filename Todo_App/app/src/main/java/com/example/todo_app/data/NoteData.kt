package com.example.todo_app.data

import com.example.todo_app.model.Note

class NoteDataResource{
    fun LoadData(): List<Note>{
        return listOf(
            Note(title = "Android Compose", description = "learn on Udemy"),
            Note(title = "Android Compose", description = "learn on Udemy"),
            Note(title = "Android Compose", description = "learn on Udemy")
        )
    }
}