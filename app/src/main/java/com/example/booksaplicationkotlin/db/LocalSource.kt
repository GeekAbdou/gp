package com.example.booksaplicationkotlin.db

import com.example.booksaplicationkotlin.model.Record
import kotlinx.coroutines.flow.Flow

interface LocalSource {

     fun getBooksFromDatabase(): Flow<List<Record>>
    suspend fun insertBooks(records:List<Record>)

    fun searchByName(data:String): Flow<List<Record>>
    fun searchByAuthor(data:String): Flow<List<Record>>
    fun searchByField(data:String): Flow<List<Record>>
    fun searchByYear(data:String): Flow<List<Record>>



}