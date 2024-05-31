package com.example.booksaplicationkotlin.network

import com.example.booksaplicationkotlin.model.BookResponse
import com.example.booksaplicationkotlin.model.RateResponse
import retrofit2.Response

class ApiClient:RemoteSource{

    private val apiService by lazy {
        RetrofitHelper.retrofit.create(ApiService::class.java)
    }

    companion object{
        private var instance:ApiClient? = null
        fun getInstance():ApiClient{
            return instance?: synchronized(this){
                val temp = ApiClient()
                instance = temp
                temp
            }

        }
    }

    override suspend fun getBooks(token: String): Response<BookResponse>? {
        return apiService.getBooks(token)
    }

    override suspend fun getSpecificBook(query: String, filter: String): Response<BookResponse>? {
        return apiService.getSpecificBook(query,filter)
    }
    override suspend fun rateBook(token: String, id: Int, rate: Float): Response<RateResponse>? {
        return apiService.rateBook(token,id,rate)
    }

}