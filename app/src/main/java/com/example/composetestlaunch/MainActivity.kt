package com.example.composetestlaunch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetestlaunch.ui.theme.ComposeTestLaunchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent(){
            AgeCalculatorApp()
        }
    }
}

@Composable
fun AgeCalculatorApp(){
    var birthYear by remember { mutableStateOf("") }
    var age by remember { mutableStateOf<Int?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){

        Text(
            text = "Enter your birth year:",
            modifier = Modifier
                .padding(10.dp)
                .padding(top = 20.dp)

        )

        TextField(
            value = birthYear,
            onValueChange = {birthYear = it},
            label = { Text("Birth Year") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)

        )

        Button(
            onClick = {
            age = calculateAge(birthYear.toIntOrNull() ?:0)
        },
                    //shape = CircleShape,
                    //modifier = Modifier.size(60.dp)
        ){
           // Box(contentAlignment = Alignment.Center)
            Text(
                text = "Calculate",
                textAlign = TextAlign.Center)
        }

        age?.let {
            Text(text = "Your age is: $it", style = MaterialTheme.typography.headlineMedium)
        }
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewAgeCalculator() {
    AgeCalculatorApp()
}