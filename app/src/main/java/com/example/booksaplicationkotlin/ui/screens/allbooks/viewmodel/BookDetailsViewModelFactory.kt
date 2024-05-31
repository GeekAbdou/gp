package com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksaplicationkotlin.model.RepositoryInterface

class BookDetailsViewModelFactory(val repositoryInterface: RepositoryInterface):ViewModelProvider.Factory {
    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(BookDetailsViewModel::class.java)){
            BookDetailsViewModel(repositoryInterface) as T
        }else{

            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}