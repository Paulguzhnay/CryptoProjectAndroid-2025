package com.example.cryptocapapp.services


import com.example.cryptocapapp.models.Asset
import com.example.cryptocapapp.models.AssetsResponse

import javax.inject.Inject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse


class CoinCapApiService @Inject constructor(
    private val client: HttpClient
){
    suspend fun getAssets(): AssetsResponse {
        //API=7118026f1941eee9cb663407aa0a1a9ca793086554be62a5c69af193e32ccd5b
        val response:HttpResponse = client.get(urlString = "https://rest.coincap.io/v3/assets?apiKey=7118")
        return response.body()
    }
}

