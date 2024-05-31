package com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import com.example.booksaplicationkotlin.model.Record
import com.example.booksaplicationkotlin.model.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class SearchBookViewModel(private val repositoryInterface: RepositoryInterface):ViewModel(){

    private val mutableSelectedBooks: MutableStateFlow<Resources<List<Record>>> = MutableStateFlow(
        Resources.Loading())

    val selectedBooks : StateFlow<Resources<List<Record>>> = mutableSelectedBooks

    fun searchByName(data:String){
        viewModelScope.launch(Dispatchers.IO){
            repositoryInterface.searchByName(data) .catch {
                mutableSelectedBooks.value = Resources.Error(it.message.toString())
            }
                .collect {
                    mutableSelectedBooks.value = Resources.Success(it)
                }

            }

    }
    fun searchByAuthor(data:String){
        viewModelScope.launch(Dispatchers.IO){
            repositoryInterface.searchByAuthor(data) .catch {
                mutableSelectedBooks.value = Resources.Error(it.message.toString())
            }
                .collect {
                    mutableSelectedBooks.value = Resources.Success(it)
                }

        }

    }
    fun searchByField(data:String){
        viewModelScope.launch(Dispatchers.IO){
            repositoryInterface.searchByField(data) .catch {
                mutableSelectedBooks.value = Resources.Error(it.message.toString())
            }
                .collect {
                    mutableSelectedBooks.value = Resources.Success(it)
                }

        }

    }
    fun searchByYear(data:String){
        viewModelScope.launch(Dispatchers.IO){
            repositoryInterface.searchByYear(data) .catch {
                mutableSelectedBooks.value = Resources.Error(it.message.toString())
            }
                .collect {
                    mutableSelectedBooks.value = Resources.Success(it)
                }

        }

    }



}