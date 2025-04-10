package com.example.cryptocapapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            AssetRowPreview(navController)
        }
        composable("cryptoMenu") {
            CryptoMenuScreen(navController)
        }
        composable("topCrypto") {
            TopCryptoScreen(navController)
        }
        composable("topNFC") {
            TopNFCScreen(navController)
        }
        composable("usaMarket") {
            USAMarketScreen(navController)
        }

    }
}

@Composable
fun AssetRow(textAR: String, size: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = textAR,
            fontSize = size.sp,
        )
    }
}

@Composable
fun FilledButtonExample(textoB: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Text(textoB)
    }
}

@Composable
fun AssetRowPreview(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
    ) {

        AssetRow("Crypto Menu", 30)
        AssetRow(" ", 30)
        FilledButtonExample("Ir a Crypto Menu") {
            navController.navigate("cryptoMenu")
        }

        AssetRow(" ", 30)
        FilledButtonExample("Ir a Top Crypto") {
            navController.navigate("topCrypto")
        }

        AssetRow(" ", 30)
        FilledButtonExample("Ir a Top NFC") {
            navController.navigate("topNFC")
        }

        AssetRow(" ", 30)
        FilledButtonExample("Ir a USA Market") {
            navController.navigate("usaMarket")
        }
    }
}