package com.example.walletui.data

import androidx.compose.ui.graphics.Brush

data class CardItem(
    val cardType: String,
    val cardNum: String,
    val cardName: String,
    val cardExp: String,
    val cardColor: Brush
)