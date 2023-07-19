package com.base.groceryapp_composeui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalContext
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
        SetupOrders()
        RenderOrderItems(
            Orders = listOf(
                OrderItems(
                    image = painterResource(R.drawable.vegetables),
                    itemname = "Vegetables",
                    dataofpurchase = "20 Jun, 2022",
                    price = "$50.65",
                    numberofitems = "6 Items"
                ),

                OrderItems(
                    image = painterResource(R.drawable.fruits),
                    itemname = "Fruits",
                    dataofpurchase = "21 Jun, 2022",
                    price = "$60.74",
                    numberofitems = "7 Items"
                ),

                OrderItems(
                    image = painterResource(R.drawable.meat),
                    itemname = "Meat",
                    dataofpurchase = "22 Jun, 2022",
                    price = "$100.74",
                    numberofitems = "3 Items"
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
            modifier=modifier.size(40.dp)
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


@Composable
fun SetupOrders(
    modifier: Modifier=Modifier
){
    val context= LocalContext.current
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text = "My Orders",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color=Color.White,
            modifier=modifier.padding(start=17.dp)
        )

        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Arrow",
            tint = Color.White,
            modifier = modifier.size(35.dp)
                .padding(end=10.dp)
                .clickable {
                    val intent= Intent(context,Cart::class.java)
                    context.startActivity(intent)
                }
        )


    }
}

@Composable
fun RenderOrderItems(
    Orders:List<OrderItems>
){

    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ){
        items(Orders.size){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    RowOrders(
                        orders = Orders[it]
                    )

                }
                Spacer(modifier = Modifier.width(150.dp))
                ColumnOrders(
                    orders = Orders[it]
                )
            }

        }
    }

}


@Composable
fun RowOrders(
    modifier: Modifier=Modifier,
    orders:OrderItems
){
    Image(
        painter = orders.image,
        contentDescription = orders.itemname,
        contentScale = ContentScale.Crop,
        modifier=modifier.size(50.dp)
            .border(
                width = 1.dp,
                color=Color.White,
                shape = CircleShape
            )
            .clip(CircleShape)
    )
    Spacer(modifier=modifier.width(13.dp))
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = orders.itemname,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color=Color.White,
            modifier=modifier.align(Alignment.Start)
                .padding(start=3.dp)
        )
        Spacer(modifier=modifier.height(4.dp))
        Text(
            text = orders.dataofpurchase,
            fontWeight = FontWeight.Light,
            color=Color.White,
            fontSize = 15.sp,
            modifier = modifier.padding(start=3.dp)
                .align(Alignment.Start)
        )
    }

}

@Composable
fun ColumnOrders(
    modifier: Modifier=Modifier,
    orders:OrderItems
){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = orders.price,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color=Color.White
        )
        Spacer(modifier=modifier.height(4.dp))

        Text(
            text = orders.numberofitems,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            color=Color.White,
            modifier = modifier.padding(end = 3.dp)
        )
    }
}
