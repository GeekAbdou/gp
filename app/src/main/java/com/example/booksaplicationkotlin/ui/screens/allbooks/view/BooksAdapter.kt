package com.example.booksaplicationkotlin.ui.screens.allbooks.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.BookItemBinding
import com.example.booksaplicationkotlin.model.Record

class BookViewModel(bookItemBinding: BookItemBinding): RecyclerView.ViewHolder(bookItemBinding.root)
class BooksDiffUtil:DiffUtil.ItemCallback<Record>(){
    override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
        return oldItem == newItem
    }

}

class BooksAdapter(val onClickListener: OnClickListener):androidx.recyclerview.widget.ListAdapter<Record, BookViewModel>(
    BooksDiffUtil()
) {
   lateinit var binding:BookItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewModel {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            , R.layout.book_item,parent, false)
        return BookViewModel(binding)

    }

    override fun onBindViewHolder(holder: BookViewModel, position: Int) {
        val current_obj = getItem(position)
        binding.book = current_obj
        binding.bookItemCardView.setOnClickListener {
            onClickListener.onClickBookItem(current_obj)
        }

        //binding.bookItemImg.let { Glide.with(holder.itemView).load(current_obj.image).centerCrop().into(it)}
       /* binding.bookItemImg.let { Glide.with(holder.itemView).load(R.drawable.book).centerCrop().into(it) }
        binding.bookItemName.text = current_obj.name
        binding.bookItemAuthorName.text = current_obj.authorName.toString()
        binding.bookItemDescriptionValue.text = current_obj.description*/

    }

}
