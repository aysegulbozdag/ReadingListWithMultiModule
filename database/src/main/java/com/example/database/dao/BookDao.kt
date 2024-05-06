package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.database.model.Book

@Dao
interface BookDao {

    @Query("Select * from Book")
    fun getAllBook() : Book

    @Insert
    fun insertBook(book: Book)
}