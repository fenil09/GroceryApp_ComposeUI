package com.base.groceryapp_composeui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(
    modifier: Modifier=Modifier
){

    Column(
        modifier = modifier.fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ){
        SectionTop()
        Spacer(modifier=Modifier.height(50.dp))
        CartSection(
            cartitems = listOf(
                CartItems(
                    image = painterResource(R.drawable.vegetables),
                    cartitemname = "Vegetables",
                    price = "$40.90",
                    countofitem = "6 Items"
                ),
                CartItems(
                    image = painterResource(R.drawable.fruits),
                    cartitemname = "Fruits",
                    price = "$40.56",
                    countofitem = "7 Items"
                ),
                CartItems(
                    image = painterResource(R.drawable.meat),
                    cartitemname = "Meat",
                    price = "$50.56",
                    countofitem = "3 Items"
                )

            )
        )
        Spacer(modifier=modifier.height(55.dp))
        Separator()
        Spacer(modifier=modifier.height(40.dp))
        QuestionBox()
        Spacer(modifier=modifier.height(80.dp))
        PayBox()
    }
}


@Composable
fun SectionTop(
    modifier: Modifier=Modifier
){
    val context= LocalContext.current
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "Backward",
        tint = Color.White,
        modifier = modifier.size(25.dp)
            .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape
            )
            .clickable {
                val intent= Intent(context,Home::class.java)
                context.startActivity(intent)
            }
    )

    Spacer(modifier=modifier.height(50.dp))
    Text(
        text = "My cart",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
}


@Composable
fun CartSection(
    cartitems:List<CartItems>
){

    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        items(cartitems.size){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RowCartItem(
                        cartitems=cartitems[it]
                    )
                }
                Spacer(modifier =  Modifier.width(120.dp))
                RowEdit()
            }
        }
    }
}

@Composable
fun RowCartItem(
    modifier: Modifier=Modifier,
    cartitems:CartItems
){
    Image(
        painter = cartitems.image,
        contentDescription = cartitems.cartitemname,
        contentScale = ContentScale.Crop,
        modifier=modifier.size(60.dp)
            .border(
                width = 1.dp,
                color=Color.White,
                shape = CircleShape
            )
            .clip(CircleShape)
    )
    Spacer(modifier=modifier.width(10.dp))
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = cartitems.cartitemname,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color=Color.White,
            modifier=modifier.align(Alignment.Start)
                .padding(start=3.dp)
        )
        Spacer(modifier=modifier.height(4.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = cartitems.price,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color=Color.White,
                modifier=modifier.padding(start = 3.dp)
            )
            Spacer(modifier=modifier.width(15.dp))
            Text(
                text = cartitems.countofitem,
                fontWeight = FontWeight.Light,
                color=Color.White,
                fontSize = 13.sp
            )
        }
    }
}


@Composable
fun RowEdit(
    modifier: Modifier=Modifier
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Icon(
            painter = painterResource(R.drawable.baseline_edit_24),
            contentDescription = "Edit",
            tint = Color.White,
            modifier = modifier.size(20.dp)
        )
        Spacer(modifier=modifier.width(6.dp))
        Text(
            text = "Edit",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color=Color.White
        )
    }
}

@Composable
fun Separator(
    modifier: Modifier=Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){

        Box(
            modifier=modifier.height(1.dp)
                .width(158.dp)
                .background(Color.White)
        ){

        }

        Spacer(modifier=modifier.width(15.dp))
        Text(
            text = "or",
            color=Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 5.dp)
        )
        Spacer(modifier=modifier.width(15.dp))

        Box(
            modifier=modifier.height(1.dp)
                .width(158.dp)
                .background(Color.White)
        ){

        }
    }
}

@Composable
fun QuestionBox(
    modifier: Modifier=Modifier
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.width(370.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colorResource(R.color.Alabaster))
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Repeat Previous Orders...",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color=Color.Black
            )
            Spacer(modifier=modifier.height(15.dp))
            Text(
                text = "Order Now",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun PayBox(
    modifier: Modifier=Modifier
){
    Box(
        modifier=modifier.width(370.dp)
            .height(95.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(15.dp)
        ) {
            Text(
                text = "Total Amount",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color=Color.Black,
                modifier=modifier.align(Alignment.Start)
            )
            Spacer(modifier=modifier.height(5.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$132.02",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color=Color.Black
                )
                Spacer(modifier=modifier.width(150.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Pay Now",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color=Color.Black
                    )
                    Spacer(modifier=modifier.width(3.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "ArrowForward",
                        tint = Color.Black,
                        modifier = modifier.size(25.dp)
                    )
                }
            }
        }
    }
}
