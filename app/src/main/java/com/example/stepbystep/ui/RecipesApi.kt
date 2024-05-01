package com.example.stepbystep.ui

import RecipesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface RecipesApi {
    @GET("recipes/complexSearch")
    suspend fun showImageRecipe(
        @Query("query") query: String,
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String
    ): RecipesResponse

    companion object {
        private const val BASE_URL = "https://api.spoonacular.com/"
        fun getInstace(): RecipesApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RecipesApi::class.java)
        }
    }
}
