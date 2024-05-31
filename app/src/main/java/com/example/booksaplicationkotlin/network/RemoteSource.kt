package com.example.booksaplicationkotlin.network

import com.example.booksaplicationkotlin.model.BookResponse
import com.example.booksaplicationkotlin.model.RateResponse
import retrofit2.Response

interface RemoteSource {
    suspend fun  getBooks(token:String):Response<BookResponse>?
    suspend fun getSpecificBook(query:String,filter:String):Response<BookResponse>?
    suspend fun rateBook(token: String,id:Int,rate:Float):Response<RateResponse>?

}