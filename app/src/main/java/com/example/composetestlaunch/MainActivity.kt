package com.example.composetestlaunch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
 * Age Calculator App
 *
 * This simple app allows users to input their birth year, and it calculates and displays their current age.
 * The app takes the user's input, performs the necessary calculations, and shows the result on the screen.
 * It's designed to be a straightforward utility that demonstrates basic usage of user input, arithmetic operations, and UI components in Jetpack Compose.
 *
 * Features:
 * - Input field for the user to enter their birth year.
 * - Button to calculate the age.
 * - Display of the user's calculated age in years.
 *
 * Components:
 * - TextField for input.
 * - Button for triggering the calculation.
 * - Text for displaying the calculated age.
 *
 * This app serves as a basic introduction to Jetpack Compose for Android development
 * and as a mini-app for the portfolio created by @ocusnir.
 *
 * Created by @ocusnir
 */


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
        }){
            Text(
                text = "Calculate",
                textAlign = TextAlign.Center)
        }

        age?.let {
            Text(text = "Your age is: $it", style = MaterialTheme.typography.headlineMedium)
        }
    }
}




/** It shows a live preview of AgeCalculatorApp composable,
 *  to help visualize how this app will look.**/
@Preview(showBackground = true)
@Composable
fun PreviewAgeCalculator() {
    AgeCalculatorApp()
}