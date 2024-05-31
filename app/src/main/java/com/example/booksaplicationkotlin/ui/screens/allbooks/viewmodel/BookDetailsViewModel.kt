package com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.model.RateResponse
import com.example.booksaplicationkotlin.model.RepositoryInterface
import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookDetailsViewModel(val repositoryInterface: RepositoryInterface):ViewModel() {

    private var response: MutableStateFlow<Resources<RateResponse>>
            = MutableStateFlow(Resources.Ideal())
    val _response: StateFlow<Resources<RateResponse>> = response

    fun rateBook(token:String,id:Int,rate:Float){

         viewModelScope.launch(Dispatchers.IO){
             response.emit(Resources.Loading())
             val responsee =repositoryInterface.rateBook(token,id,rate)
             Log.d("TAG", "response: ${responsee?.isSuccessful}")
             if (responsee != null ) {
                 if(responsee.isSuccessful && responsee.code() == 200){
                     response.emit(Resources.Success(responsee.body()))
                 }else{
                     response.emit(Resources.Error(responsee.message()))
                 }

             }
         }
     }
}