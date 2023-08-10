package com.example.todo_app.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo_app.R
import com.example.todo_app.components.ButtonNote
import com.example.todo_app.components.NoteInputText
import com.example.todo_app.data.NoteDataResource
import com.example.todo_app.model.Note
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note)->Unit,
    onRemoveNote:(Note)->Unit
){
    var title by remember{
        mutableStateOf("")
    }
    var description  by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
                          Text(text = stringResource(id = R.string.app_name))
        },
        actions = {
                  Icon(imageVector = Icons.Default.Notifications, contentDescription = "Icon")
        }, colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.White)
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
            NoteInputText(modifier = Modifier
                .padding(
                    top = 9.dp,
                    bottom = 8.dp
                )
                .background(color = Color.White),
                text = title, onValueChange = {
                      if (it.all { char-> char.isLetter() || char.isWhitespace() })title = it
                }, label = "title"){
            }
            NoteInputText(modifier = Modifier
                .padding(
                    top = 9.dp,
                    bottom = 8.dp
                )
                .background(color = Color.White),
                text = description, onValueChange = {
                    if (it.all { char-> char.isLetter() || char.isWhitespace() })description = it
                }, label = "Add a note") {
            }
            ButtonNote(text = "Save", onClick = {
                if(title.isNotEmpty() && description.isNotEmpty()){
                    onAddNote(Note(title = title, description =  description))
                    title = "";
                    description = "";
                    Toast.makeText(context, "Note added",
                                    Toast.LENGTH_SHORT).show()
                }
            })
        }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn{
             items(notes){
                 Note-> NoteRow(note = Note, onNoteClick = {
                     onRemoveNote(it)
             })
             }
        }
    }
}
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClick: (Note)-> Unit
){
    Surface(modifier = Modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
        shadowElevation = 40.dp,
        tonalElevation = 10.dp,
        color = Color.LightGray
    ) {
        Column(modifier = Modifier
            .clickable {
                onNoteClick(note)
            }
            .padding(
                horizontal = 14.dp,
                vertical = 6.dp
            ),
            horizontalAlignment = Alignment.Start) {
                Text(text = note.title,
                    style = MaterialTheme.typography.titleLarge)
                Text(text = note.description,
                    style = MaterialTheme.typography.titleMedium)
                //Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
               // style = MaterialTheme.typography.titleSmall)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun DemoNoteScreen(){
    /*
    val notes = remember {
        mutableStateListOf<Note>()
    }
    NoteScreen(notes = notes, onAddNote = { notes.add(it)
    }, onRemoveNote = {
        notes.remove(it)
    })

     */

}