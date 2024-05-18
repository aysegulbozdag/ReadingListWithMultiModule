package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.model.Book

@Dao
interface BookDao {

    @Query("Select * from Book")
    fun getAllBook() : List<Book>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)
}