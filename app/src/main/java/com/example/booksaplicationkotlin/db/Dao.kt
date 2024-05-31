package com.example.booksaplicationkotlin.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.booksaplicationkotlin.model.Record
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books:List<Record>)

    @Query("select * from Books")
    fun getBooksFromDatabase(): Flow<List<Record>>

    @Query("select * from Books where LTRIM(RTRIM(name)) LIKE '%' || :data || '%' ")
    fun searchByName(data:String): Flow<List<Record>>
    @Query("select * from Books where LTRIM(RTRIM(authorName)) LIKE '%' || :data || '%' ")
    fun searchByAuthor(data:String): Flow<List<Record>>

    @Query("select * from Books where LTRIM(RTRIM(category)) LIKE '%' || :data || '%'")
    fun searchByField(data:String): Flow<List<Record>>

    @Query("select * from Books where LTRIM(RTRIM(publishingYear)) LIKE '%' || :data || '%' ")
    fun searchByYear(data:String): Flow<List<Record>>


}