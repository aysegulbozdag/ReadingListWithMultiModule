package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo("bookName")
    val bookName:String
)
