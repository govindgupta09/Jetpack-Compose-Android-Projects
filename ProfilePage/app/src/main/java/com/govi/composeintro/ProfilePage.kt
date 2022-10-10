package com.govi.composeintro

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage() {
    Card(
        elevation = 6.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
    ) {
        //Content of our card including img , text and buttons.
        Column(Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.me),
                contentDescription = "Me Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red, shape = CircleShape
                    ), contentScale = ContentScale.Crop
            )
            Text(text = "Govind Gupta", fontWeight = FontWeight.Bold)
            Text(text = "From India")
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ProfileStats("150", "Followers")
                ProfileStats("110", "Following")
                ProfileStats("50", "Posts")
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(text = "150", fontWeight = FontWeight.Bold)
//                Text(text = "Followers")
//            }
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(text = "110", fontWeight = FontWeight.Bold)
//                Text(text = "Following")
//            }
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(text = "50", fontWeight = FontWeight.Bold)
//                Text(text = "Posts")
//            }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Follow User")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Direct Message")
                }
            }
        }
    }
}

@Composable
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePageReview() {
    ProfilePage()
}