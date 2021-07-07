package com.antino.labs_antino.network

import com.antino.labs_antino.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("top-headlines")
    suspend fun getDataFromApi(@Query("country") country:String,
    @Query("apiKey")apiKey:String): RecyclerList

}