package com.govi.thursdaytrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.govi.thursdaytrivia.ui.theme.ThursdayTriviaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThursdayTriviaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeImage()
                }
            }
        }
    }
}

@Composable
fun ComposeImage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.composelogo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(16.dp)
                .size(300.dp)
        )
        Text(
            text = "Govind Gupta",fontSize = 30.sp, fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.nameColor),
            modifier = Modifier
                .padding(16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.love_emoji),
            contentDescription = "LoveEmoji",
            modifier = Modifier
                .padding(16.dp)
                .size(100.dp)
        )
        Text(
            text = "Jetpack Compose", fontSize = 30.sp ,fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.textColor),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposePreview() {
    ComposeImage()
}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ThursdayTriviaTheme {
//        //Greeting("Android")
//    }
//}