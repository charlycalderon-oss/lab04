package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageWithDescription(modifier = Modifier.padding(innerPadding))
                    ButtonExample()
                    WelcomeText()
                }
            }
        }
    }
}

@Composable
fun ImageWithDescription(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.monorico),
            contentDescription = "Imagen del laboratorio"
        )
        Text(text = "Esta es la descripción de la imagen")
    }
}

@Composable
fun ButtonExample() {
    var message by remember { mutableStateOf("Presiona el botón") }
    Column {
        Text(text = message)
        Button(onClick = { message = "¡Botón presionado!" }) {
            Text("Presióname")
        }
    }
}

@Composable
fun WelcomeText() {
    Text(
        text = "¡Bienvenido al laboratorio 04!",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}



@Preview(showBackground = true)
@Composable
fun ImageWithDescriptionPreview() {
    Lab04Theme {
        ImageWithDescription()
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonExamplePreview() {
    Lab04Theme {
        ButtonExample()
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeTextPreview() {
    Lab04Theme {
        WelcomeText()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab04Theme {
        //Greeting("Android")
    }
}