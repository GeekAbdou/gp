package com.example.booksaplicationkotlin

import android.content.SharedPreferences
import android.util.Log

class ReadxSharedPreferences(private val sharedPreferences: SharedPreferences) {

     fun saveToken(token: String) {
        sharedPreferences.edit().apply {
            putString(TOKEN_KEY, token).apply()
            Log.d("NI", token)

        }
    }

     fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, "")
    }

    suspend fun deleteToken() {
        sharedPreferences.edit().remove(TOKEN_KEY).apply()
    }

    companion object {
        private const val TOKEN_KEY = "token"
    }
}
