package com.example.booksaplicationkotlin.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    val builder = OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()
    //val client =  OkHttpClient.Builder().addInterceptor(interceptor).build()

    val url = "https://readx.up.railway.app/api/"
    val gson = GsonBuilder().setLenient().create()
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(builder)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}