package com.base.groceryapp_composeui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.base.groceryapp_composeui.ui.theme.GroceryApp_ComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        SetupHomeScreen(
            image = painterResource(R.drawable.grocery2)
        )
        }
    }
}


@Composable
fun SetupHomeScreen(
    image: Painter,
    modifier: Modifier=Modifier
    ){
    val context= LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxHeight()
            .background(Color.Black)
    ) {
        Image(
            painter = image,
            contentDescription = "SetupImage",
            modifier=modifier.size(350.dp)
                .clip(RoundedCornerShape(45.dp))
                .background(Color.Black)
        )

        Text(
            text = "We Deliver grocery at your doorstep...",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 25.sp,
            modifier = modifier.padding(start = 25.dp)
                .align(Alignment.Start)
        )

        Text(
            text = "We have Fresh Vegetables and Fruits,\n"+
            "Order Fresh items from Us",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            color=Color.White,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.defaultMinSize(minWidth = 180.dp, minHeight = 50.dp)
                .clip(RoundedCornerShape(45.dp))
                .background(Color.Cyan)
                .clickable {
                    val intent=Intent(context,Home::class.java)
                    context.startActivity(intent)
                }
        ) {
                     Text(
                         text = "Get Started",
                         fontWeight = FontWeight.SemiBold,
                         color = Color.White
                     )
        }
    }
}


