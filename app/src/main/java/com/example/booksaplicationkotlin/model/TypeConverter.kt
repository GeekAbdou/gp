package com.example.booksaplicationkotlin.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class TypeConverter {

    @TypeConverter
    fun fromBookToString(book:Record) = Gson().toJson(book)
    @TypeConverter
    fun fromStringToBooks(currentString : String) = Gson().fromJson(currentString,Record::class.java)

}