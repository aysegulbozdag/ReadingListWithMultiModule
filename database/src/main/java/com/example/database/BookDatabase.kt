package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.BookDao
import com.example.database.model.Book

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao
}