package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.BookDatabase
import com.example.database.BookRepoImpl
import com.example.database.BookRepository
import com.example.database.dao.BookDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideBookDao(bookDatabase: BookDatabase) = bookDatabase.bookDao()

    @Provides
    fun providesPostRepository(postDao: BookDao):BookRepository =
        BookRepoImpl(postDao)

    @Provides
    @Singleton
    fun provideBookDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, BookDatabase::class.java, "BookDatabase").build()
}