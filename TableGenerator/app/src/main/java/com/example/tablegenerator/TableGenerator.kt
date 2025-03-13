package com.example.tablegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tablegenerator.ui.theme.TableGeneratorTheme

/*
 * Multiplication Table Generator
 *
 * This simple app allows users to input a number, and it generates
 * a multiplication table for that number from 1 to 10.
 *
 * Features:
 * - Takes user input for a number.
 * - Uses a loop to generate and display the multiplication table.
 * - Handles invalid inputs with exception handling.
 *
 * This mini-app is part of a portfolio showcasing Kotlin fundamentals,
 * including loops, conditionals, and exception handling.
 *
 * Created by @ocusnir
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TableGenerator()
        }
    }
}

@Composable
fun TableGenerator() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        Text(
            text = "TableGenerator",
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centers text horizontally
                .padding(10.dp)
                .padding(top = 20.dp)

        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTableGenerator() {
    TableGenerator()
}
