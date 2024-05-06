package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.BookDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideBookDao(bookDatabase: BookDatabase) = bookDatabase.bookDao()

    @Provides
    @Singleton
    fun provideBookDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, BookDatabase::class.java, "BookDatabase").build()
}