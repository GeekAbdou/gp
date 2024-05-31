package com.example.booksaplicationkotlin.db

import android.content.Context
import androidx.room.*
import com.example.booksaplicationkotlin.model.Record

@Database(entities = [Record::class], version = 1)
@TypeConverters(com.example.booksaplicationkotlin.model.TypeConverter::class)
abstract class AppDatabase: RoomDatabase(){

    abstract fun Dao():Dao
    companion object{
        private var INSTANCE:AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context ,AppDatabase::class.java
                ,"books_database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE= instance
                instance
            }
        }
    }



}