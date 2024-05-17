package com.example.database

import com.example.database.dao.BookDao
import com.example.database.model.Book
import javax.inject.Inject

class BookRepoImpl @Inject constructor(private val bookDao: BookDao) : BookRepository {
    override fun insertBook(bookName: String) {
        bookDao.insertBook(Book(bookName = bookName))
    }
}