package com.example.jettip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettip.ui.theme.JetTipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTipTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun TopHeader(totalPerPerson: Float = 134.0f){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .height(120.dp),
        color = Color(0x3BDA03C4),
        shape = RoundedCornerShape(corner = CornerSize(15.dp))) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            val total = "%.2f".format(totalPerPerson)
            Text(text = "Total Per Person",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text(text = "$$total",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContent(){
    Surface(modifier = Modifier.fillMaxWidth().
            padding(10.dp).
            height(150.dp),
            border = BorderStroke(width = 1.dp, color = Color.Black),
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
    ){

    }
}