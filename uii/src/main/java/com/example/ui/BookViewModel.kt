package com.example.ui

import androidx.lifecycle.ViewModel
import com.example.database.dao.BookDao
import com.example.database.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val bookDao: com.example.database.dao.BookDao) : ViewModel() {

    fun addBook(bookName: String) {
        bookDao.insertBook(com.example.database.model.Book(bookName = bookName))
    }
}