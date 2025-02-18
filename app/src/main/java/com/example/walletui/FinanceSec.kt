package com.example.walletui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.StackedLineChart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletui.data.FinanceItem
import com.example.walletui.ui.theme.B2
import com.example.walletui.ui.theme.G2
import com.example.walletui.ui.theme.O2
import com.example.walletui.ui.theme.P2


val f_item = listOf(
    FinanceItem(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        name = "My\nBusiness",
        background = O2
    ),
    FinanceItem(
        icon = Icons.Rounded.AccountBalance,
        name = "Finance\nAnalytics",
        background = P2
    ),
    FinanceItem(
        icon = Icons.Rounded.AccountBalanceWallet,
        name = "Allot\nFunds",
        background = B2
    ),
    FinanceItem(
        icon = Icons.Rounded.StackedLineChart,
        name = "Buy\nStocks",
        background = G2
    ),
    FinanceItem(
        icon = Icons.Rounded.Description,
        name = "My\nStatement",
        background = G2
    )
)


@Composable
fun FinanceSec(){
    Column{
        Text(
            text = "Finance",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(f_item.size) {
                FinanceItemIndex(it)
            }
        }
    }
}

@Composable
fun FinanceItemIndex(
    index: Int
) {
    val finance = f_item[index]
    var lastFinanceEnd = 0.dp
    if(index == f_item.size - 1) {
         lastFinanceEnd = 16.dp
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastFinanceEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }
}