package com.example.cryptocapapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AssetRow(textAR:String, size: Int){
    Row(modifier = Modifier
        .fillMaxWidth()
    ){
        Text(
            text=textAR,
            fontSize = size.sp,
            )
        }

    }
@Composable
fun FilledButtonExample(textoB: String,onClick: () -> Unit) {
    Button(
        modifier=Modifier
            .fillMaxWidth(),
    onClick = { onClick()})
    {
        Text(textoB)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun AssetRowPreview(){
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Cyan
            )


    ){
        AssetRow("Crypto Menu",30)
        AssetRow("",20)
        AssetRow("Menu",20)
        AssetRow("",20)
        FilledButtonExample("Crypto Menu",onClick={})
        AssetRow("",20)
        FilledButtonExample ("Top Crypto",onClick={})
        AssetRow("",20)
        FilledButtonExample("Top NFC",onClick={})
        AssetRow("",20)
        FilledButtonExample ("USA Market",onClick={})
    }

}