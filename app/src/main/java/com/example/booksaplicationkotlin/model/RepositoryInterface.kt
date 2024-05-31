package com.example.booksaplicationkotlin.model

import com.example.booksaplicationkotlin.model.BookResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Query

interface RepositoryInterface {
    suspend fun  getBooks(token:String): Response<BookResponse>?

    suspend fun getSpecificBook(query: String, filter:String): Response<BookResponse>?

    suspend fun rateBook(token: String,id:Int,rate:Float):Response<RateResponse>?


    fun getBooksFromDatabase():Flow<List<Record>>

     suspend fun insertBooks(books:List<Record>)

    fun searchByName(data:String): Flow<List<Record>>
    fun searchByAuthor(data:String): Flow<List<Record>>
    fun searchByField(data:String): Flow<List<Record>>
    fun searchByYear(data:String): Flow<List<Record>>


    fun searchProjectByName(data:String): Flow<List<GradProject>>
    fun searchProjectByAuthor(data:String): Flow<List<GradProject>>
    fun searchProjectByField(data:String): Flow<List<GradProject>>
    fun searchProjectByYear(data:String): Flow<List<GradProject>>

}