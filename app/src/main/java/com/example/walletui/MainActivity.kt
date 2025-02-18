package com.example.walletui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walletui.ui.theme.WalletUITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletUITheme {
                BarColor(color = MaterialTheme.colorScheme.background)
               //Surface for 'background' color for the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScr()
                }
            }
        }
    }
}

@Composable
private fun BarColor(color: Color){
    val systemUIController = rememberSystemUiController()
    SideEffect {
        systemUIController.setStatusBarColor(
            color = color
        )
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScr() {
    Scaffold(
        bottomBar = {
            BottomNavBar()
        }
    ) { padding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            WalletSec()
            CardSec()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSec()
            CurrencySec()
        }
    }
}