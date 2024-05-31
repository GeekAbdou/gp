package com.example.readx.di

import android.content.Context
import android.content.SharedPreferences
import com.example.booksaplicationkotlin.ReadxSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("ReadxSharedPreference", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideReadxSharedPreferences(sharedPreferences: SharedPreferences): ReadxSharedPreferences {
        return ReadxSharedPreferences(sharedPreferences)
    }
}
