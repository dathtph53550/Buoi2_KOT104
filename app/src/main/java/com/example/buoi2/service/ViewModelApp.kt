package com.example.buoi2.service

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buoi2.models.Product
import kotlinx.coroutines.launch

class ViewModelApp : ViewModel() {
    //lay du lieu data product tu server
    private val _listProduct = mutableStateOf<List<Product>?>(null)
    var listProduct: State<List<Product>?> = _listProduct


    fun getListProduct(){
        viewModelScope.launch {
            try {
                _listProduct.value = RetrofitInstance.api.getProducts()
            }catch (e:Exception){
                Log.d("===",e.message.toString())
            }
        }
    }

    //XOA DU
    fun deleteProduct(id:String) {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.deleteProduct(id)
                if (result.isSuccessful) {
                    Log.d("===", result.message())
                    getListProduct()
                } else {
                    Log.d("===", result.message())
                }
            }catch (e:Exception){
                Log.d("===",e.message.toString())
            }
        }
    }

    //cap nhat du lieu
    fun updateProduct(id:String,product: Product) {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.updateProduct(id, product)
                if (result.isSuccessful) {
                    Log.d("===", result.message())
                    getListProduct()
                } else {
                    Log.d("===", result.message())
                }
            } catch (e: Exception) {
                Log.d("===", e.message.toString())
            }
        }
    }


    fun addProduct(product: Product) {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.createProduct(product)
                if (result.isSuccessful) {
                    Log.d("===", result.message())
                    getListProduct()
                } else {
                    Log.d("===", result.message())
                }
            } catch (e: Exception) {
                Log.d("===", e.message.toString())
            }
        }
    }



}