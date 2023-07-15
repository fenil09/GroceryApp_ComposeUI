package com.base.groceryapp_composeui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
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
        Spacer(modifier = Modifier.height(35.dp))
        SetupCategory()
        Spacer(modifier = Modifier.height(20.dp))
        Category(
            categoryitem = listOf(
                CategoryItems(
                    image = painterResource(R.drawable.vegetables),
                    nameofimage = "Vegetables"
                ),

                CategoryItems(
                    image = painterResource(R.drawable.fruits),
                    nameofimage = "Fruits"
                ),
                CategoryItems(
                    image = painterResource(R.drawable.meat),
                    nameofimage = "Meat"
                )
            )
        )
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

@Composable
fun SetupCategory(
    modifier: Modifier=Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            modifier= modifier.padding(start=17.dp)
        )
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Arrow",
            tint = Color.White,
            modifier = modifier.size(35.dp)
                .padding(end=10.dp)
        )
    }
}


@Composable
fun Category(
 categoryitem:List<CategoryItems>,
 modifier: Modifier=Modifier
){
  LazyRow {
      items(categoryitem.size){
          Box(
              contentAlignment = Alignment.Center,
              modifier = modifier.width(160.dp)
                  .height(250.dp)
                  .padding(start = 20.dp,top=20.dp, bottom = 50.dp)
                  .clip(RoundedCornerShape(15.dp))
                  .background(Color.White)

          ){
              Column(
                  verticalArrangement = Arrangement.Center
              ) {
                  CategoryItems(
                      categoryitem[it]
                  )
              }
          }
      }
  }
}

@Composable
fun CategoryItems(
    categoryItems: CategoryItems,
    modifier: Modifier=Modifier
){
    Image(
        painter = categoryItems.image,
        contentDescription = categoryItems.nameofimage,
        modifier=modifier.size(130.dp)
            .padding(20.dp)
    )

    Spacer(modifier=modifier.height(8.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.width(200.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Cyan)
    ){
        Text(
            text = categoryItems.nameofimage,
            fontWeight = FontWeight.Bold,
            color=Color.Black,
            fontSize = 15.sp

        )
    }
}

