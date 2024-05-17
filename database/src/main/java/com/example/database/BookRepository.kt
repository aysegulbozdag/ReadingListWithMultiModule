package com.example.database

import com.example.database.dao.BookDao
import com.example.database.model.Book
import javax.inject.Inject

interface BookRepository {
    fun insertBook(bookName: String)
}