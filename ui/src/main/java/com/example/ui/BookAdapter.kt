package com.example.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.database.model.Book
import com.example.ui.databinding.RvItemBinding

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.BookViewHolder {
        val binding: RvItemBinding =
            RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    inner class BookViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.txtBookName.text = book.bookName
        }

    }

    override fun onBindViewHolder(holder: BookAdapter.BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size

}