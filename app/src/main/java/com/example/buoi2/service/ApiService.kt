package com.example.buoi2.service

import com.example.buoi2.models.Product
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @POST("products")
    suspend fun createProduct(@Body product: Product): Response<Unit>

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id:String):Response<Unit>

    @PUT("products/{id}")
    suspend fun updateProduct(@Path("id") id:String,
                              @Body product: Product):Response<Unit>


}

object RetrofitInstance{
    private const val BASE_URL="http://10.24.38.10:3000/"
    val  api :ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}