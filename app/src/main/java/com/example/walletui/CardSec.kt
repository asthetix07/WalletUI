package com.example.walletui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletui.data.CardItem
import com.example.walletui.ui.theme.B1
import com.example.walletui.ui.theme.B2
import com.example.walletui.ui.theme.G1
import com.example.walletui.ui.theme.G2
import com.example.walletui.ui.theme.O1
import com.example.walletui.ui.theme.O2
import com.example.walletui.ui.theme.P1
import com.example.walletui.ui.theme.P2


val c_items = listOf(

    CardItem(
        cardType = "VISA",
        cardNum = "2305 4510 3457 6013",
        cardName = "AKASH",
        cardExp = "VALID THRU 02/28",
        cardColor = cardGradientCol(B1, B2)
    ),
    CardItem(
        cardType = "MASTERCARD",
        cardNum = "2345 4543 3455 6433",
        cardName = "VYOM",
        cardExp = "VALID THRU 12/26",
        cardColor = cardGradientCol(O1, O2)
    ),
    CardItem(
        cardType = "VISA",
        cardNum = "1345 4513 3455 0033",
        cardName = "BUCKY",
        cardExp = "VALID THRU 06/31",
        cardColor = cardGradientCol(P1, P2)
    ),
    CardItem(
        cardType = "MASTERCARD",
        cardNum = "0945 6943 3105 6883",
        cardName = "GROOT",
        cardExp = "VALID THRU 03/27",
        cardColor = cardGradientCol(G1, G2)
    )
)


fun cardGradientCol(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}


@Composable
fun CardSec(){
    LazyRow(){
        items(c_items.size){ index ->
            CardItemIndex(index)
        }
    }
}


@Composable
fun CardItemIndex(
     index: Int
) {
    val card = c_items[index]
    var lastCardEnd = 0.dp
    if (index == c_items.size - 1) {
        lastCardEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.visa_logo_transparent_free_png)
    if (card.cardType == "MASTERCARD") {
        image = painterResource(id = R.drawable.mastercard_7_logo_png_transparent)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastCardEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.cardColor)
                .width(255.dp)
                .height(175.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardExp,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNum,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}