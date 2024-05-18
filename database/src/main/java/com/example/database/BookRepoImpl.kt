package com.example.database

import com.example.database.dao.BookDao
import com.example.database.di.IoDispatcher
import com.example.database.model.Book
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookRepoImpl @Inject constructor(
    private val bookDao: BookDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BookRepository {
    override suspend fun insertBook(bookName: String) = withContext(ioDispatcher) {
        bookDao.insertBook(Book(bookName = bookName))
    }

    override suspend fun getBooks(): List<Book> = withContext(ioDispatcher) {
        bookDao.getAllBook()
    }

}