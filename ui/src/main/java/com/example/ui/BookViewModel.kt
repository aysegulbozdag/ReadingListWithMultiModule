package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.BookRepository
import com.example.database.model.Book


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val bookRepository: BookRepository) : ViewModel() {

    private var _booksState: MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    val bookState = _booksState.asStateFlow()

    init {
        getBooks()
    }

    fun addBook(bookName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            bookRepository.insertBook(bookName)
            getBooks()
        }
    }

   private fun getBooks() {
        viewModelScope.launch(Dispatchers.IO) {
           _booksState.value = bookRepository.getBooks()
        }
    }
}