package com.base.groceryapp_composeui

import androidx.compose.ui.graphics.painter.Painter

data class CartItems(
val image:Painter,
    val cartitemname:String,
    val price:String,
    val countofitem:String
)
