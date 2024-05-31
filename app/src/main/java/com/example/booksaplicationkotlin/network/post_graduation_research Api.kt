package com.example.myapplicationresearch.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object post_graduation_research_Api {
    private val base_url = "https://readx.up.railway.app/api/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(post_graduation_research_ApiService::class.java)


}