package com.example.cryptocapapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.cryptocapapp.models.Asset
import com.example.cryptocapapp.services.CoinCapApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel

class AssetsListViewModel @Inject constructor(
    private val apiService: CoinCapApiService
):ViewModel() {
    private val _assets = MutableStateFlow<List<Asset>>(emptyList())
    val assets: StateFlow<List<Asset>> = _assets

    init {
        fetchAssets()

    }

    private fun fetchAssets(){
        viewModelScope.launch {
            try {
                val result = apiService.getAssets()
                _assets.value = result
            }catch (e: Exception){
                // Todo:Handle error
            }
        }

    }

}