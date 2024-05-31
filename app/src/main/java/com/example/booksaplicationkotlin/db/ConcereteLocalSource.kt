package com.example.booksaplicationkotlin.db

import android.content.Context
import com.example.booksaplicationkotlin.model.Record
import kotlinx.coroutines.flow.Flow

class ConcereteLocalSource(context: Context ):LocalSource{

    private val dao:Dao by lazy {
        val db = AppDatabase.getInstance(context)
        db.Dao()
    }

    override fun getBooksFromDatabase(): Flow<List<Record>> {
       return  dao.getBooksFromDatabase()
    }

    override suspend fun insertBooks(books: List<Record>) {
        dao.insertBooks(books)
    }

    override fun searchByName(data: String): Flow<List<Record>> {
        return dao.searchByName(data)
    }

    override fun searchByAuthor(data: String): Flow<List<Record>> {
        return dao.searchByAuthor(data)
    }

    override fun searchByField(data: String): Flow<List<Record>> {
        return dao.searchByField(data)
    }

    override fun searchByYear(data: String): Flow<List<Record>> {
        return dao.searchByYear(data)
    }

}