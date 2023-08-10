package com.example.todo_app.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
     modifier: Modifier = Modifier,
     text: String,
     maxLine: Int = 1,
     onValueChange: (String)->Unit,
     label: String,
     onImeAction: ()->Unit
){
     val keyboardController = LocalSoftwareKeyboardController.current
     TextField(
          value = text,
          onValueChange = onValueChange,
          colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
          maxLines = maxLine,
          label = { Text(text = label) },
          keyboardOptions = KeyboardOptions(
               imeAction = ImeAction.Done
          ),
          keyboardActions = KeyboardActions(
               onDone = {
                    onImeAction()
                    keyboardController?.hide()
               }
          ),
          modifier = modifier
     )

}

@Composable
fun ButtonNote(
     modifier: Modifier = Modifier,
     enable: Boolean = true,
     text: String,
     onClick: ()->Unit
){
     Button(onClick = onClick,
          enabled = enable,
          modifier = modifier,
          shape = CircleShape
          ) {
          Text(text = text)
     }
}