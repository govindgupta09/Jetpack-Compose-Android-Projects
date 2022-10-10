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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage() {
    Card(
        elevation = 6.dp,
        modifier = Modifier
            //.fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
    ) {
        //Content of our card including img , text and buttons.

        //below line is for scrollable of card components
        //(modifier = Modifier.verticalScroll(rememberScrollState()))
        ConstraintLayout(modifier = Modifier.verticalScroll(rememberScrollState())) {
            val (image, nameText, spaceText, rowText,
                rowButton, buttonFollow, buttonMessage) = createRefs()

            val guidline = createGuidelineFromTop(0.2f)

            Image(
                painter = painterResource(id = R.drawable.me),
                contentDescription = "Me Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red, shape = CircleShape
                    )
                    .constrainAs(image) {
                        top.linkTo(guidline)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(nameText.top)
                    },
                contentScale = ContentScale.Crop
            )
            Text(text = "Govind Gupta",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(nameText) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(spaceText.top)
                    })
            Text(text = "From India",
                modifier = Modifier
                    .constrainAs(spaceText) {
                        top.linkTo(nameText.bottom)
                        bottom.linkTo(rowText.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(rowText) {
                        top.linkTo(spaceText.bottom)
                        //start.linkTo(parent.start)
                        //end.linkTo(parent.end)
                        bottom.linkTo(rowButton.top)
                    }
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
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(buttonFollow) {
                        top.linkTo(rowText.bottom, margin = 16.dp )
                        start.linkTo(parent.start)
                        end.linkTo(buttonMessage.start)
                        bottom.linkTo(parent.bottom)
                        width= Dimension.wrapContent
                    }) {
                Text(text = "Follow User")
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(buttonMessage) {
                        top.linkTo(rowText.bottom, margin = 16.dp)
                        start.linkTo(buttonFollow.end)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.wrapContent
                    }) {
                Text(text = "Direct Message")
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