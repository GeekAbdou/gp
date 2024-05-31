package com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksaplicationkotlin.model.RepositoryInterface

class SearchBookViewModelFactory(private val repositoryInterface: RepositoryInterface):
    ViewModelProvider.Factory{
    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(SearchBookViewModel::class.java)){
            SearchBookViewModel(repositoryInterface) as T
        }else{
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}