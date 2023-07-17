package com.base.groceryapp_composeui

import androidx.compose.ui.graphics.painter.Painter

data class OrderItems(
    val image: Painter,
    val itemname:String,
    val dataofpurchase:String,
    val price:String,
    val numberofitems:String
)
