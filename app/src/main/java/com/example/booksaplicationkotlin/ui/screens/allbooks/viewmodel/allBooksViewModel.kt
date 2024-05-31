package com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import com.example.booksaplicationkotlin.model.BookResponse
import com.example.booksaplicationkotlin.model.Record
import com.example.booksaplicationkotlin.model.RepositoryInterface
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class allBooksViewModel(private val repositoryInterface: RepositoryInterface): ViewModel() {


    private var allBooks:MutableStateFlow<Resources<BookResponse>>
         = MutableStateFlow(Resources.Ideal())
    val all_books:StateFlow<Resources<BookResponse>> = allBooks

    private val mutableBooksFromRoom:MutableStateFlow<Resources<List<Record>>> = MutableStateFlow(
        Resources.Loading())

    val booksFromRoom :StateFlow<Resources<List<Record>>> = mutableBooksFromRoom


    fun getBooks(token:String){

        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler){
            allBooks.emit(Resources.Loading())
            val response =repositoryInterface.getBooks(token)
            Log.d("TAG", "response: ${response?.isSuccessful}")
            if (response != null ) {
                if(response.isSuccessful && response.code() == 200){

                    allBooks.emit(Resources.Success(response.body()))

                }else{
                    allBooks.emit(Resources.Error(response.message()))
                }

            }
        }
    }

    suspend fun insertBooks(books: List<Record>) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryInterface.insertBooks(books)
        }
    }
    fun getBooksFromDatabase(){
        viewModelScope.launch(Dispatchers.IO){
            repositoryInterface.getBooksFromDatabase()
                .catch {
                    mutableBooksFromRoom.value = Resources.Error(it.message.toString())
                }
                .collect {
                    mutableBooksFromRoom.value = Resources.Success(it)
                }

        }

    }






}