package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database.dao.BookDao
import com.example.database.model.Book

@Database(entities = [com.example.database.model.Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao(): com.example.database.dao.BookDao
}