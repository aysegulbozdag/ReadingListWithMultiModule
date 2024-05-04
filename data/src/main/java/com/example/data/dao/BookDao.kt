package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.Book

@Dao
interface BookDao {

    @Query("Select * from Book")
    fun getAllBook() : Book

    @Insert
    fun insertBook(book: Book)
}