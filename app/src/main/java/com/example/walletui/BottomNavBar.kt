package com.example.walletui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.NotificationsActive
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.walletui.data.BottomNavItem

val b_items = listOf(
    BottomNavItem(
        title = "Home",
        icon = Icons.Rounded.Home
    ),

    BottomNavItem(
        title = "Wallet",
        icon = Icons.Rounded.AccountBalanceWallet
    ),

    BottomNavItem(
        title = "Notification",
        icon = Icons.Rounded.NotificationsActive
    ),

    BottomNavItem(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)


@Composable
fun BottomNavBar() {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            b_items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}
