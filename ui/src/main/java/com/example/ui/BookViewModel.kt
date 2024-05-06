package com.example.ui

import androidx.lifecycle.ViewModel
import com.example.database.dao.BookDao
import com.example.database.model.Book

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val bookDao: BookDao) : ViewModel() {

    fun addBook(bookName: String) {
        bookDao.insertBook(Book(bookName = bookName))
    }
}