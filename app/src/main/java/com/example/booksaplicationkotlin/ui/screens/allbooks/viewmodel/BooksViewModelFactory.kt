package com.example.booksaplicationkotlin.books.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksaplicationkotlin.model.RepositoryInterface
import com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel.allBooksViewModel

class BooksViewModelFactor(private val repositoryInterface: RepositoryInterface):ViewModelProvider.Factory{
    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(allBooksViewModel::class.java)){
            allBooksViewModel(repositoryInterface) as T
        }else{

            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}