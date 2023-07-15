package com.base.groceryapp_composeui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainHome(){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(35.dp))
        GreetingSection()
    }
}



@Composable
fun TopSection(
    modifier: Modifier=Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
            .padding(15.dp)
    ){
        Row(
           verticalAlignment = Alignment.CenterVertically,
        ){
            Icon(
                painter = painterResource(R.drawable.baseline_location_on_24),
                tint = Color.White,
                contentDescription = "Location",
                modifier = modifier.size(15.dp)
            )
            Spacer(modifier=modifier.width(3.dp))
            Text(
                text = "California Los Angeles",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 15.sp
            )
        }
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile",
            contentScale = ContentScale.Crop,
            modifier=modifier.size(45.dp)
                .clip(CircleShape)

        )
    }
}

@Composable
fun GreetingSection(
    modifier: Modifier=Modifier,
){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(horizontal = 18.dp)
    ) {
        Text(
            text = "Good Morning Jimmy...",
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            color=Color.White
        )
        Spacer(modifier=modifier.height(12.dp))
        Text(
            text = "Let's order fresh\n"+
            "items for you...",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
        )
    }
}